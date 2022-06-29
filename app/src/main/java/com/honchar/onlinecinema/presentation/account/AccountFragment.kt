package com.honchar.onlinecinema.presentation.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.extensions.loadCircleImage
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.databinding.FragmentAccountBinding
import com.honchar.onlinecinema.databinding.SettingItemBinding
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.account.adapter.AccountSettingHolder
import com.honchar.onlinecinema.presentation.account.model.SettingAction
import com.honchar.onlinecinema.presentation.account.model.UserDataModel
import com.honchar.onlinecinema.presentation.films.FilmsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment : BaseFragment<FragmentAccountBinding>(
    R.layout.fragment_account,
    FragmentAccountBinding::inflate
) {
    override val viewModel: AccountViewModel by viewModel()

    private val settingsAdapter = BaseViewBindingAdapter()
        .map(
            SettingItemBinding::inflate,
            AccountSettingHolder(::onSettingClick)
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSettingsList()
    }

    override fun initViews() {
        super.initViews()
        binding.rvSettings.adapter = settingsAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUserData()
    }

    override fun subscribeData() {
        super.subscribeData()
        observeData(viewModel.settingsLiveData, settingsAdapter::loadItems)
        observeData(viewModel.userDataLiveData, ::initUserInfo)
    }

    private fun initUserInfo(userData: UserDataModel) {
        binding.ivUserAvatar.loadCircleImage(userData.avatar, R.drawable.ic_empty_user)
        binding.tvUserName.text = userData.fullName
    }

    private fun onSettingClick(action: SettingAction) {
        when (action) {
            SettingAction.Wishlist -> {
                val arrayList = ArrayList(FilmsFactory.getFilms().filter { it.isLater })
                startActivity(Intent(requireContext(), FilmsActivity::class.java).apply {
                    putParcelableArrayListExtra(FilmsActivity.FILMS, arrayList)
                })
            }
            SettingAction.Favorite -> {

                val arrayList = ArrayList(FilmsFactory.getFilms().filter { it.isLike })
                startActivity(Intent(requireContext(), FilmsActivity::class.java).apply {
                    putParcelableArrayListExtra(FilmsActivity.FILMS, arrayList)
                })
            }
            SettingAction.Language -> {

            }
            SettingAction.Edit -> {
                navigationHandler?.displayFragment(
                    EditAccountFragment(),
                    EditAccountFragment::class.java.name
                )
            }
            SettingAction.Exit -> {

            }
        }
    }
}