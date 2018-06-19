/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display7segmentos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author dmemije
 */
public class MainFrame extends javax.swing.JFrame {
        
    protected final static int NUM_INPUT = 7; // 0 a F
    protected final static int NUM_OUTPUT = 4; // 0 a 3
    protected final static int NUM_HIDDEN = 8;
    protected final static double RATE = 0.5;
    protected final static double MOMENTUM = 0.7;       
    
    protected static Network network = new Network(NUM_INPUT, NUM_HIDDEN, NUM_OUTPUT, RATE, MOMENTUM);   
    
    public static double[][] variablesDisplay;       

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();       
        Display7Segmentos.setVariables();
        
        variablesDisplay = new double[1][7];
        for(int i = 0; i < 7; i++){
            variablesDisplay[0][i] = 0;
        }        
        
        btnA.addActionListener((e) -> {
            if(variablesDisplay[0][0] == 0){
                variablesDisplay[0][0] = 1;
                btnA.setBackground(Color.red);
            }else{
                variablesDisplay[0][0] = 0;
                btnA.setBackground(Color.white);
            }
        });
        
        btnB.addActionListener((e) -> {
            if (variablesDisplay[0][1] == 0) {
                variablesDisplay[0][1] = 1;
                btnB.setBackground(Color.red);
            } else {
                variablesDisplay[0][1] = 0;
                btnB.setBackground(Color.white);
            }
        });
        
        btnC.addActionListener((e) -> {
            if (variablesDisplay[0][2] == 0) {
                variablesDisplay[0][2] = 1;
                btnC.setBackground(Color.red);
            } else {
                variablesDisplay[0][2] = 0;
                btnC.setBackground(Color.white);
            }
        });
        
        btnD.addActionListener((e) -> {
            if (variablesDisplay[0][3] == 0) {
                variablesDisplay[0][3] = 1;
                btnD.setBackground(Color.red);
            } else {
                variablesDisplay[0][3] = 0;
                btnD.setBackground(Color.white);
            }
        });
        
        btnE.addActionListener((e) -> {
            if (variablesDisplay[0][4] == 0) {
                variablesDisplay[0][4] = 1;
                btnE.setBackground(Color.red);
            } else {
                variablesDisplay[0][4] = 0;
                btnE.setBackground(Color.white);
            }
        });
        
        btnF.addActionListener((e) -> {
            if (variablesDisplay[0][5] == 0) {
                variablesDisplay[0][5] = 1;
                btnF.setBackground(Color.red);
            } else {
                variablesDisplay[0][5] = 0;
                btnF.setBackground(Color.white);
            }
        });
        
        btnG.addActionListener((e) -> {
            if (variablesDisplay[0][6] == 0) {
                variablesDisplay[0][6] = 1;
                btnG.setBackground(Color.red);
            } else {
                variablesDisplay[0][6] = 0;
                btnG.setBackground(Color.white);
            }
        });
        
        btnTrain.addActionListener((e)->{
           train();
           btnTrain.setEnabled(false);
           btnRun.setEnabled(true);
        });
        
        btnRun.addActionListener((e) -> {
            double[] evaluate = evaluate(variablesDisplay);
            txtS0.setText(String.format("%.5g%n", evaluate[0]));
            txtS1.setText(String.format("%.5g%n", evaluate[1]));
            txtS2.setText(String.format("%.5g%n", evaluate[2]));
            txtS3.setText(String.format("%.5g%n", evaluate[3]));
            double[] evaluate2 = new double[4];
            double[][] target = Display7Segmentos.getSalidas();
            for (int i = 0; i < evaluate2.length; i++) {
                if (evaluate[i] > 0.5) {
                    evaluate2[i] = 1;
                } else {
                    evaluate2[i] = 0;
                }
            }
            for (int i = 0; i < target.length; i++) {

                if (target[i][0] == evaluate2[0] && target[i][1] == evaluate2[1] && target[i][2] == evaluate2[2] && target[i][3] == evaluate2[3]) {
                    if (i < 10) {
                        jLabel5.setText("Resultado: Número " + i);
                    } else if (i == 10) {
                        jLabel5.setText("Resultado: Letra A");
                    } else if (i == 11) {
                        jLabel5.setText("Resultado: Letra B");
                    } else if (i == 12) {
                        jLabel5.setText("Resultado: Letra C");
                    } else if (i == 13) {
                        jLabel5.setText("Resultado: Letra D");
                    } else if (i == 14) {
                        jLabel5.setText("Resultado: Letra E");
                    } else if (i == 15) {
                        jLabel5.setText("Resultado: Letra F");
                    }
                }
            }
        });

    }
    
    protected double[] evaluate(double[][] value) {
        double xorData[][] = variablesDisplay;
        int update = 0;

        NumberFormat nf = NumberFormat.getInstance();
        double d[] = network.computeOutputs(xorData[0]);
       
        return d;

    }
    
    protected void train() {
        double[][] entradas = Display7Segmentos.getEntradas();
        double[][] salidas = Display7Segmentos.getSalidas();
        
        int update = 0;

        int max = 1000000;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < entradas.length; j++) {
                network.computeOutputs(entradas[j]);
                network.calcError(salidas[j]);
                network.learn();
            }

            update++;
            if (update == 100) {
                System.out.println("Cycles Left:" + (max - i) + ",Error:" + network.getError(entradas.length));
                update = 0;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRun = new javax.swing.JButton();
        btnTrain = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        txtS0 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtS1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtS2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtS3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnRun.setText("Reconocer");
        btnRun.setEnabled(false);

        btnTrain.setText("Entrenar");

        btnA.setBackground(new java.awt.Color(255, 255, 255));
        btnA.setText("a");
        btnA.setPreferredSize(new java.awt.Dimension(80, 40));

        btnF.setBackground(new java.awt.Color(255, 255, 255));
        btnF.setText("f");
        btnF.setPreferredSize(new java.awt.Dimension(40, 80));

        btnB.setBackground(new java.awt.Color(255, 255, 255));
        btnB.setText("b");
        btnB.setPreferredSize(new java.awt.Dimension(40, 80));

        btnG.setBackground(new java.awt.Color(255, 255, 255));
        btnG.setText("g");
        btnG.setPreferredSize(new java.awt.Dimension(80, 40));

        btnC.setBackground(new java.awt.Color(255, 255, 255));
        btnC.setText("c");
        btnC.setPreferredSize(new java.awt.Dimension(40, 80));

        btnE.setBackground(new java.awt.Color(255, 255, 255));
        btnE.setText("e");
        btnE.setPreferredSize(new java.awt.Dimension(40, 80));

        btnD.setBackground(new java.awt.Color(255, 255, 255));
        btnD.setText("d");
        btnD.setPreferredSize(new java.awt.Dimension(80, 40));

        jLabel1.setText("S3:");

        jLabel2.setText("S2:");

        jLabel3.setText("S1:");

        jLabel4.setText("S0:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(108, 108, 108)
                            .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTrain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRun))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtS1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtS0, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtS2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtS3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtS0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrain)
                    .addComponent(btnRun))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnTrain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtS0;
    private javax.swing.JTextField txtS1;
    private javax.swing.JTextField txtS2;
    private javax.swing.JTextField txtS3;
    // End of variables declaration//GEN-END:variables
}
