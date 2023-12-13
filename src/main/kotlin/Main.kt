//import graph.TaskGraph
import javax.swing.SwingUtilities
import gui.landingPage.LandingFrame
import gui.loginScreen.LoginFrame

// driver class
fun main(args: Array<String>)
{
    SwingUtilities.invokeLater {
        LandingFrame()
    }
}