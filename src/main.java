public class main 
{
    public static void main(String[] args)
    { 
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                cadastroVIEW cadastro = new cadastroVIEW();
                cadastro.setVisible(true);
            }
        });
    }
}
