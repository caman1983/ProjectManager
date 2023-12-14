//import graph.TaskGraph
import javax.swing.SwingUtilities
import gui.landingPage.MainFrame
import gui.loginScreen.LoginFrame

// driver class
fun main(args: Array<String>)
{
    SwingUtilities.invokeLater {
        MainFrame()
        //LoginFrame()
    }
}