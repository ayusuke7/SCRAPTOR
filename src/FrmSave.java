
import java.awt.AWTException;
import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author AYU7-WN
 */
public class FrmSave extends javax.swing.JFrame {

    private int positionx, positiony;

    public String path = System.getProperty("user.dir");
    public String nome = "";
    public String format = "jpeg";

    private final DefaultListModel model;
    public Timer timer;
    public JLabel status;

    /**
     * Creates new form FrmCapturador
     *
     * @param lista
     */
    
    public FrmSave(JList lista) {
        initComponents();
        this.model = (DefaultListModel) lista.getModel();
        setAcessibilidade();
        setIcone();
    }
    
    private void setIcone() {
        // coloca uma figura na barra de título da janela
        URL url = this.getClass().getResource("icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);

    }

    private void setAcessibilidade() {

        JRootPane root = getRootPane();

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "SPACE");
        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");

        root.getActionMap().put("SPACE", new AbstractAction("SPACE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                capture();
            }
        });

        root.getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                
                if(timer != null){
                    timer.stop();
                    status.setText("Finalizado");
                }
            }
        });

    }

    public void setTransparenteFrame(float opacidade) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        if (gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            this.setOpacity(opacidade);
        }
    }

    public void capture() {

        try {
            Rectangle rect = new Rectangle(this.getLocation().x, this.getLocation().y,
                    this.getSize().width, this.getSize().height);

            this.setVisible(false);

            BufferedImage screen = new Robot().createScreenCapture(rect);
            SimpleDateFormat df = new SimpleDateFormat("HHmmss");
            String captura = path + "\\" + nome + "-" + df.format(new Date()) + "." + format;
            ImageIO.write(screen, format, new File(captura));

            this.setVisible(true);

            this.model.addElement("[CAPTURA] - " + captura);

        } catch (AWTException | IOException ex) {
            this.model.addElement("[ERRO] - " + ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        positiony = evt.getX();
        positionx = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - positiony, y - positionx);
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
