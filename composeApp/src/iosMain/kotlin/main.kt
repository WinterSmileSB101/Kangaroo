import androidx.compose.ui.window.ComposeUIViewController
import org.smilesb101.kangaroo.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
