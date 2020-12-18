package gv.randomdevs.org;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class Application extends JFrame {
	String name;
	private static final long serialVersionUID = -2517616123689799182L;
	public Application(String name) {
		this.name=name;
        initUI();
    }
    private void initUI() {
        add(new Board());
        setSize(250, 200);
        setTitle(this.name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}