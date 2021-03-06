package org.scaloid.util

import android.content.Context
import org.scaloid.common._
import android.view.View

/**
 * Responsive layout.
 *
 * Refer to the URL below for more details:
 *
 * [[http://blog.scaloid.org/2013/02/android-multiple-layout-directory.html]]
 */
class ResponsiveLayout(implicit context: Context) extends SLinearLayout {
  if (Config.portrait) orientation = VERTICAL
  private var first = true

  override def +=(v: View) = {
    if (first) {
      v.<<(if (Config.portrait) FILL_PARENT else WRAP_CONTENT, WRAP_CONTENT)
      first = false
    }
    super.+=(v)
  }
}
