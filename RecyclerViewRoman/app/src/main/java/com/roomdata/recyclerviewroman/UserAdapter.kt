package com.roomdata.recyclerviewroman

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.roomdata.recyclerviewroman.databinding.ItemUserBinding
import com.roomdata.recyclerviewroman.model.User
import com.roomdata.recyclerviewroman.model.UserService

interface UserActionListener{
    fun onUserMove(user: User, moveBy: Int)

    fun onUserDelete(user: User)

    fun onUserDetails(user: User)
}

class UsersDiffUtilCallBack(
    private val oldList: List<User>,
    private val newList: List<User>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser= oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser= oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser == newUser
    }

}

class UserAdapter(private val actionListener: UserActionListener)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>(), View.OnClickListener {

    var users: List<User> = emptyList()
       set(value) {
           val diffCallback = UsersDiffUtilCallBack(field, value)
           val diffResult = DiffUtil.calculateDiff(diffCallback)
           field = value
           diffResult.dispatchUpdatesTo(this)
       }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemUserBinding = ItemUserBinding.inflate(layoutInflater, parent, false)
        binding.root.setOnClickListener(this)
        binding.moreImageViewButton.setOnClickListener(this)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = users[position]
        with(holder.binding){
            holder.itemView.tag = user
            moreImageViewButton.tag = user
            userNameTextView.text = user.name
            userCompanyTextView.text = user.company
            if(user.photo.isNotBlank()){
                Glide.with(photoImageView.context)
                    .load(user.photo)
                    .circleCrop()
                    .placeholder(R.drawable.ic_user_avatar)
                    .error(R.drawable.ic_user_avatar)
                    .into(photoImageView)
            }else{
                photoImageView.setImageResource(R.drawable.ic_user_avatar)
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onClick(v: View?) {
        val user = v?.tag as User
        when(v.id){
            R.id.moreImageViewButton -> {
                showPopupMenu(v)
            } else -> {
                actionListener.onUserDetails(user)
            }
        }
    }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(v.context, v)
        val user = v.tag as User
        val position = users.indexOfFirst { it.id == user.id }
        popupMenu.menu.add(0, ID_MOVE_UP, Menu.NONE, "Move up").apply {
            isEnabled = position > 0
        }
        popupMenu.menu.add(0, ID_MOVE_DOWN, Menu.NONE, "Move down").apply {
            isEnabled = position < users.size - 1
        }
        popupMenu.menu.add(0, ID_REMOVE, Menu.NONE, "Remove")

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                ID_MOVE_UP -> {
                    actionListener.onUserMove(user, -1)
                }
                ID_MOVE_DOWN -> {
                    actionListener.onUserMove(user, 1)
                }
                ID_REMOVE -> {
                    actionListener.onUserDelete(user)
                }
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    companion object{
        private const val ID_MOVE_UP = 1
        private const val ID_MOVE_DOWN = 2
        private const val ID_REMOVE = 3
    }
}