import java.awt.Component;
import java.awt.Frame;
import java.awt.Window;
import lombok.NonNull;

public class Window { 
    public void new(@NonNull string frameName, @NonNull int width, @NonNull int height, int closeEvent) { //sto creando una nuova finestra, questo dovrebbe essere un costruttore in teoria
           JFrame frame = new JFrame(frameName); //nuovo Frame di JFrame, non usiamo Window perché è più macchinoso
           if (closeEvent == null) { closeEvent = JFrame.DISPOSE_ON_CLOSE);} //se closeEvent non esiste allora esci alla chiusura
           frame.setDefaultCloseOperation(closeEvent); //altrimenti usa l'argomento fornito
           frame.setSize(width, height); //impostiamo la grandezza della finestra
           return frame; //restituiamo la finestra (altrimenti non sarebbe un costruttore)
    }
    
    public void obliterate(@Nonnull JFrame frame) { //questa funzione fa da "distruttore", cancella una finestra senza triggerare eventi come se la finestra fosse stata rimossa dalla memoria
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //resettiamo l'operazione di default in chiusura per sicurezza
            frame.setVisible(false);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED)); //invochiamo l'evento che determina che la finestra è ora chiusa
    }
}
