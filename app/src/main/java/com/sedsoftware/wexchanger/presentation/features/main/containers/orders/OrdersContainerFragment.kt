package com.sedsoftware.wexchanger.presentation.features.main.containers.orders

import android.content.Context
import androidx.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.sedsoftware.wexchanger.R
import com.sedsoftware.wexchanger.commons.annotation.Layout
import com.sedsoftware.wexchanger.di.AppScope
import com.sedsoftware.wexchanger.presentation.base.BaseContainerFragment
import com.sedsoftware.wexchanger.presentation.features.main.di.OrdersContainerModule
import ru.terrakok.cicerone.Navigator
import toothpick.Toothpick

@Layout(R.layout.fragment_tab_container)
class OrdersContainerFragment : BaseContainerFragment(), OrdersContainerView {

  companion object {
    fun newInstance(tag: String?) = OrdersContainerFragment().apply {
      arguments = bundleOf(CONTAINER_TAG_KEY to tag)
    }
  }

  override val localNavigator: Navigator
    get() =
      Toothpick
        .openScope(AppScope.TAB_ORDERS)
        .getInstance(Navigator::class.java)

  @InjectPresenter
  lateinit var presenter: OrdersContainerPresenter

  @ProvidePresenter
  fun providePresenter(): OrdersContainerPresenter =
    Toothpick
      .openScope(AppScope.TAB_ORDERS)
      .getInstance(OrdersContainerPresenter::class.java)

  override fun onAttach(context: Context?) {
    Toothpick
      .openScopes(AppScope.APPLICATION, AppScope.TAB_ORDERS)
      .apply {
        installModules(OrdersContainerModule(this@OrdersContainerFragment))
        Toothpick.inject(this@OrdersContainerFragment, this)
      }

    super.onAttach(context)
  }

  override fun onDetach() {
    Toothpick.closeScope(AppScope.TAB_ORDERS)
    super.onDetach()
  }
}
