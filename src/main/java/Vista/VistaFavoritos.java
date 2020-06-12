package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VistaFavoritos extends JPanel{

	private ListaFavoritos lista;
	
	public VistaFavoritos() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel etiquiteaFavoritos = new JLabel("Favoritos: ");
		etiquiteaFavoritos.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		add(etiquiteaFavoritos,BorderLayout.NORTH);
		
		lista = new ListaFavoritos();
		add(lista, BorderLayout.CENTER);
	}
	
	public ListaFavoritos getListaFavoritos() {
		return lista;
	}
	
	public void setActionListeners(ActionListener l) {
		lista.setActionListeners(l);
	}
	
	
	
}
