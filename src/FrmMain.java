
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;

/**
 *
 * @author AYU7-WN
 */
public class FrmMain extends javax.swing.JFrame {

    private final FrmSave cap;
    private final Dimension dimension;
    private final DefaultListModel model;
    private Timer time;

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        setIcone();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        spinerLargura.setModel(new SpinnerNumberModel(480, 10, dimension.width, 100));
        spinerAltura.setModel(new SpinnerNumberModel(360, 10, dimension.height, 100));

        model = new DefaultListModel();
        jList1.setModel(model);

        cap = new FrmSave(this.jList1);

    }

    private void iniciar() {

        if (!txtPrefixo.getText().equals("")) {

            if (!txtSalvar.getText().equals("")) {
                cap.path = txtSalvar.getText();
            }

            cap.nome = txtPrefixo.getText();
            cap.format = getFormat();

            setDimension();

            cap.setOpacity((float) jSlider1.getValue() / 10);
            cap.setFocusable(false);
            cap.setVisible(true);

            lbStatus.setText("Iniciado, utilize a tecla de ESPACO p/ capturar");

            if (checkTime.isSelected()) {
                time();
                lbStatus.setText("Iniciado, timer habilitado, capturando...");
            }

        } else {
            model.addElement("[INFO] - Informe um prefixo para salvar as capturas");
        }
    }

    private void finalizar() {

        if (cap != null && cap.isShowing()) {
            cap.dispose();
        }

        if (time != null && time.isRunning()) {
            time.stop();
        }
        
        lbStatus.setText("Finalizado");
        spinerTime.setEnabled(true);
        checkTime.setEnabled(true);

    }

    private void time() {

        int value = (int) spinerTime.getValue() * 1000;
        time = new Timer(value, (ActionEvent e) -> {
            cap.capture();
        });

        time.start();
        cap.timer = time;
        cap.status = lbStatus;
    }

    private void setIcone() {
        // coloca uma figura na barra de título da janela
        URL url = this.getClass().getResource("icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);

    }

    private void setDimension() {

        if (rbCustom.isSelected()) {
            int lar = (int) spinerLargura.getValue();
            int alt = (int) spinerAltura.getValue();
            cap.setSize(new Dimension(lar, alt));
        } else {
            cap.setSize(dimension);
        }

    }

    private String getFormat() {

        String formato;

        if (rbJPEG.isSelected()) {
            formato = "jpeg";
        } else if (rbPNG.isSelected()) {
            formato = "png";
        } else if (rbBMP.isSelected()) {
            formato = "bmp";
        } else {
            formato = "gif";
        }

        return formato;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSalvar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrefixo = new javax.swing.JTextField();
        rbCustom = new javax.swing.JRadioButton();
        rbFullscreen = new javax.swing.JRadioButton();
        spinerLargura = new javax.swing.JSpinner();
        spinerAltura = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        rbJPEG = new javax.swing.JRadioButton();
        rbPNG = new javax.swing.JRadioButton();
        rbBMP = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbGIF = new javax.swing.JRadioButton();
        checkTime = new javax.swing.JCheckBox();
        spinerTime = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lbStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuIniciar = new javax.swing.JMenuItem();
        menuFinalizar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCRAPTOR");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(386, 443));
        setResizable(false);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(0, 102, 153));
        jToolBar1.setRollover(true);

        jLabel3.setText("   ");
        jToolBar1.add(jLabel3);

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iniciar.png"))); // NOI18N
        jButton1.setText("Capturar");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setMaximumSize(new java.awt.Dimension(120, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(120, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jLabel5.setText(" ");
        jToolBar1.add(jLabel5);

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalizar.png"))); // NOI18N
        jButton2.setText("Finalizar");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton2.setMaximumSize(new java.awt.Dimension(120, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(120, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel6.setText(" ");
        jToolBar1.add(jLabel6);

        jButton3.setBackground(new java.awt.Color(0, 102, 153));
        jButton3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton3.setMaximumSize(new java.awt.Dimension(120, 50));
        jButton3.setMinimumSize(new java.awt.Dimension(120, 50));
        jButton3.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jLabel4.setText("  ");
        jToolBar1.add(jLabel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Salvar em ");

        txtSalvar.setEditable(false);
        txtSalvar.setBackground(new java.awt.Color(255, 255, 255));
        txtSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalvarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prefixo ");

        txtPrefixo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrefixo.setText("Captura");

        rbCustom.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCustom);
        rbCustom.setText("Definido");
        rbCustom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCustomItemStateChanged(evt);
            }
        });

        rbFullscreen.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbFullscreen);
        rbFullscreen.setSelected(true);
        rbFullscreen.setText("Fullscreen");
        rbFullscreen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbFullscreenItemStateChanged(evt);
            }
        });

        spinerLargura.setModel(new javax.swing.SpinnerNumberModel(0, null, 100, 1));
        spinerLargura.setToolTipText("Largura");
        spinerLargura.setEnabled(false);
        spinerLargura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinerLarguraStateChanged(evt);
            }
        });

        spinerAltura.setModel(new javax.swing.SpinnerNumberModel());
        spinerAltura.setToolTipText("Altura");
        spinerAltura.setEnabled(false);
        spinerAltura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinerAlturaStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tamanho");

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setMaximum(10);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("Transparência da Captura");
        jSlider1.setValue(5);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("40.0%");

        rbJPEG.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbJPEG);
        rbJPEG.setSelected(true);
        rbJPEG.setText("JPEG");
        rbJPEG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbJPEGItemStateChanged(evt);
            }
        });

        rbPNG.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbPNG);
        rbPNG.setText("PNG");

        rbBMP.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbBMP);
        rbBMP.setText("BMP");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Formato");

        rbGIF.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbGIF);
        rbGIF.setText("GIF");

        checkTime.setBackground(new java.awt.Color(255, 255, 255));
        checkTime.setText("Timer, Habilita a captura com intervalos em segundos");
        checkTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkTimeItemStateChanged(evt);
            }
        });
        checkTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTimeActionPerformed(evt);
            }
        });

        spinerTime.setModel(new javax.swing.SpinnerNumberModel(2, 1, 60, 1));
        spinerTime.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rbFullscreen, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbCustom)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spinerLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rbJPEG)
                                                .addGap(34, 34, 34)
                                                .addComponent(rbPNG)
                                                .addGap(26, 26, 26)
                                                .addComponent(rbBMP)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbGIF)
                                            .addComponent(spinerAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbFullscreen)
                    .addComponent(rbCustom)
                    .addComponent(spinerLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbJPEG)
                    .addComponent(rbPNG)
                    .addComponent(rbBMP)
                    .addComponent(jLabel9)
                    .addComponent(rbGIF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTime)
                    .addComponent(spinerTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        lbStatus.setText(" ");

        jMenu1.setText("Comandos");

        menuIniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuIniciar.setText("Iniciar");
        menuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIniciarActionPerformed(evt);
            }
        });
        jMenu1.add(menuIniciar);

        menuFinalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuFinalizar.setText("Finalizar");
        menuFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFinalizarActionPerformed(evt);
            }
        });
        jMenu1.add(menuFinalizar);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        jMenuItem2.setText("Capturar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatus))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:       
        iniciar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        finalizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalvarMouseClicked
        // TODO add your handling code here:
        JFileChooser janela = new JFileChooser();
        janela.setApproveButtonText("Selecionar");
        janela.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (janela.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = janela.getSelectedFile().getAbsolutePath();
            txtSalvar.setText(path);
        }
    }//GEN-LAST:event_txtSalvarMouseClicked

    private void rbCustomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCustomItemStateChanged
        // TODO add your handling code here:

        if (rbCustom.isSelected()) {
            spinerLargura.setEnabled(true);
            spinerAltura.setEnabled(true);
        }

        setDimension();

    }//GEN-LAST:event_rbCustomItemStateChanged

    private void rbFullscreenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbFullscreenItemStateChanged
        // TODO add your handling code here:

        if (rbFullscreen.isSelected()) {
            spinerLargura.setEnabled(false);
            spinerAltura.setEnabled(false);
        }

        setDimension();

    }//GEN-LAST:event_rbFullscreenItemStateChanged

    private void menuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIniciarActionPerformed
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_menuIniciarActionPerformed

    private void menuFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFinalizarActionPerformed
        // TODO add your handling code here:
        finalizar();
    }//GEN-LAST:event_menuFinalizarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if (this.getExtendedState() == 0) {
            this.setExtendedState(JFrame.ICONIFIED);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:

        float value = jSlider1.getValue();
        jLabel8.setText(value * 10 + "%");

        if (cap.isShowing()) {
            cap.setOpacity(value / 10);
        }

    }//GEN-LAST:event_jSlider1StateChanged

    private void spinerLarguraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinerLarguraStateChanged
        // TODO add your handling code here:
        setDimension();
    }//GEN-LAST:event_spinerLarguraStateChanged

    private void spinerAlturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinerAlturaStateChanged
        // TODO add your handling code here:
        setDimension();
    }//GEN-LAST:event_spinerAlturaStateChanged

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
        JOptionPane.showMessageDialog(null,
                "1 - Escolha um local de saida e um prefixo para as capturas\n"
                + "2 - Escolha um nivel de transparência do capturador\n"
                + "3 - Inicie o Capturador, Tela-cheia ou Modo definido\n"
                + "4 - Posicione sobre o local de captura\n"
                + "5 - Utilize o ESPAÇO no teclado para capturar\n"
                + "6 - Utilize a tecla para ESC Finalizar\n"
                + "\nSaiba mais: http://alexandrehenrique.esy.es/\n",
                "AJUDA", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:

        if (jList1.getModel().getSize() > 0) {
            if (evt.getClickCount() > 1) {
                try {
                    String value = jList1.getSelectedValue();
                    if (value.contains("[CAPTURA]")) {
                        File file = new File(value.replace("[CAPTURA] - ", ""));
                        Desktop.getDesktop().open(file);
                    }
                } catch (IOException ex) {
                    model.addElement("[ERRO] - Problemas ao abrir o arquivo!\n" + ex.getMessage());
                }
            }
        }


    }//GEN-LAST:event_jList1MouseClicked

    private void rbJPEGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbJPEGItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_rbJPEGItemStateChanged

    private void checkTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkTimeItemStateChanged
        // TODO add your handling code here:
        if (checkTime.isSelected()) {
            spinerTime.setEnabled(true);
        } else {
            spinerTime.setEnabled(false);
        }
    }//GEN-LAST:event_checkTimeItemStateChanged

    private void checkTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkTimeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMain().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JMenuItem menuFinalizar;
    private javax.swing.JMenuItem menuIniciar;
    private javax.swing.JRadioButton rbBMP;
    private javax.swing.JRadioButton rbCustom;
    private javax.swing.JRadioButton rbFullscreen;
    private javax.swing.JRadioButton rbGIF;
    private javax.swing.JRadioButton rbJPEG;
    private javax.swing.JRadioButton rbPNG;
    private javax.swing.JSpinner spinerAltura;
    private javax.swing.JSpinner spinerLargura;
    private javax.swing.JSpinner spinerTime;
    private javax.swing.JTextField txtPrefixo;
    private javax.swing.JTextField txtSalvar;
    // End of variables declaration//GEN-END:variables
}
