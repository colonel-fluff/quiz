import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Klasse zur Beschreibung einer Methodenbox mit Textfeldern und Bildern
 * @author Klaus Reinold
 * @version 1.0
 */

public class Methodenbox extends JFrame implements KeyListener
{

    private JLabel labelText;
    private ArrayList<Bildanzeige> bilderliste;
    private ArrayList<Textanzeige> textliste;

    /**
     * Erzeugt eine neue Methodenbox für das Arbeiten mit Bildern und Textfeldern
     */
    Methodenbox()
    {
        setSize(800, 600);
        setLocation(20, 30);
        bilderliste = new ArrayList<Bildanzeige>();
        textliste = new ArrayList<Textanzeige>();
        setLayout(null);
        setSize(800, 600);
        setVisible(true);
        addKeyListener(this);
    }


    /**
     * Hinzufügen eines Bildes
     * @param id eindeutiger Bezeichner des Bildes
     * @param dateiangabe füge das Bild im BlueJ-Projekt in den Ordner bilder ein und gib dann z. B. an "bilder/dateiname.png"
     * @param xPos x-Position der linken oberen Ecke des Bildes. 
     * @param yPos y-Position der linken oberen Ecke des Bildes
     * @param breite Breite des Bildes
     * @param hoehe Höhe des Bildes
     */
    public void fuegeBildHinzu(String id, String dateiangabe, int xPos, int yPos, int breite, int hoehe)
    {
        for (Bildanzeige b: bilderliste)
        {
            if(b.gibID() == id)
            {
                System.out.println("Eindeutige Bild-ID bereits vergeben. Bild wird nicht eingefügt");
                return;
            }
        }
        bilderliste.add(new Bildanzeige(id, dateiangabe, xPos, yPos, breite, hoehe, this));
    }


    /**
     * Methode zum Entfernen des Bildes
     * @param id der eindeutige Bezeichner des Bildes
     */
    public void entferneBild(String id)
    {
        for (Bildanzeige b: bilderliste)
        {
            if(b.gibID() == id)
            {
                b.gibLabel().setVisible(false);
                remove(b.gibLabel());
                bilderliste.remove(b);
                return;
            }
        }
    }

    /**
     * Methode zum Ersetzen des Bildes durch eine andere Datei
     * @param id der eindeutige Bezeichner des Bildes
     * @param dateiNeu Pfad und Name der neuen Datei, z. B. "bilder/blume.jpg"
     */
    public void ersetzeBild(String id, String dateiNeu)
    {
        for (Bildanzeige b: bilderliste)
        {
            if(b.gibID() == id)
            {
                b.setzeIcon(new ImageIcon(dateiNeu));
            }
        }
    }

    /**
     * Methode zum Verändern der Bildgröße
     * @param id der eindeutige Bezeichner des Bildes
     * @param breite Breite des Bildes
     * @param hoehe Höhe des Bildes
     */
    public void setzeBildgroesse(String id, int breite, int hoehe)
    {
        for (Bildanzeige b: bilderliste)
        {
            if(b.gibID() == id)
            {
                b.setzeGroesse(breite, hoehe);
            }
        }
    }

    /**
     * Methode zum Verändern der Position
     * @param id der eindeutige Bezeichner des Bildes
     * @param xPos neue x-Position der linken oberen Ecke des Bildes
     * @param yPos neue y-Position der linken oberen Ecke des Bildes
     */
    public void setzeBildposition(String id, int xPos, int yPos)
    {
        for (Bildanzeige b: bilderliste)
        {
            if(b.gibID() == id)
            {
                b.setzePosition(xPos, yPos);
            }
        }
    }

    /**
     * Hinzufügen eines Textfeldes
     * @param id eindeutiger Bezeichner des Textfelds
     * @param text darzustellender Text
     * @param xPos x-Position der linken oberen Ecke des Textfeldes 
     * @param yPos y-Position der linken oberen Ecke des Textfeldes
     * @param breite Breite des Textfelds
     * @param hoehe Höhe des Textfelds
     */
    public void fuegeTextHinzu(String id, String text, int xPos, int yPos, int breite, int hoehe)
    {
        for (Textanzeige t: textliste)
        {
            if(t.gibID() == id)
            {
                System.out.println("Eindeutige Text-ID bereits vergeben. Text wird nicht eingefügt");
                return;
            }
        }
        textliste.add(new Textanzeige(id, text, xPos, yPos, breite, hoehe, this));
    }

    /**
     * Methode zum Entfernen des Textfeldes
     * @param id der eindeutige Bezeichner des Textfelds
     */
    public void entferneText(String id)
    {
        for (Textanzeige t: textliste)
        {
            if(t.gibID() == id)
            {
                t.gibTextfeld().setVisible(false);
                remove(t.gibTextfeld());
                textliste.remove(t);
                return;
            }
        }
    }

    /**
     * Methode zum Ersetzen des Textes im Textfeld
     * @param id der eindeutige Bezeichner des Textfelds
     * @param textNeu der neue Text
     */
    public void ersetzeText(String id, String textNeu)
    {
        for (Textanzeige t: textliste)
        {
            if(t.gibID() == id)
            {
                t.setzeText(textNeu);
            }
        }
    }

    /**
     * Methode zum Ändern der Größe des Textfeldes
     * @param id der eindeutige Bezeichner des Textfelds
     * @param breite neue Breite
     * @param hoehe neue Höhe
     */
    public void setzeTextfeldgroesse(String id, int breite, int hoehe)
    {
        for (Textanzeige t: textliste)
        {
            if(t.gibID() == id)
            {
                t.setzeGroesse(breite, hoehe);
            }
        }
    }

    /**
     * Methode zum Ändern der Position des Textfeldes
     * @param id der eindeutige Bezeichner des Textfelds
     * @param xPos neue x-Position
     * @param yPos neue y-Position
     */
    public void setzeTextposition(String id, int xPos, int yPos)
    {
        for (Textanzeige t: textliste)
        {
            if(t.gibID() == id)
            {
                t.setzePosition(xPos, yPos);
            }
        }
    }

    /**
     * Zeitverzögerung
     * @param millisekunden Wartezeit
     */
    public void warte(int sekunden)
    {
        long ende = System.currentTimeMillis() + 1000*sekunden;
        while (System.currentTimeMillis() < ende)
        {
            try
            {
                Thread.sleep(ende - System.currentTimeMillis());
            }
            catch (Exception e){};
        }
    }

    /**
     * Methode zum Reagieren auf das Ereignis Taste wird gedrückt
     * @param e Das Ereignis. Mit e.getKeyChar() erfährt man, welche Taste gedrückt wurde.
     */
    @Override public void keyTyped(KeyEvent e) 
    {  

    }  

    /**
     * Methode zum Reagieren auf das Ereignis Taste ist gedrückt
     * @param e Das Ereignis. Mit e.getKeyChar() erfährt man, welche Taste gedrückt wurde.
     */
    @Override public void keyPressed(KeyEvent e) 
    {  

    }  

    /**
     * Methode zum Reagieren auf das Ereignis Taste wird losgelassen
     * @param e Das Ereignis. Mit e.getKeyChar() erfährt man, welche Taste gedrückt wurde.
     */
    @Override public void keyReleased(KeyEvent e) 
    {  

    }  

    private class Bildanzeige
    {
        private String id;
        private ImageIcon icon;
        private JLabel label;
        private Methodenbox methodenbox;

        Bildanzeige(String idNeu, String dateiangabe, int xPos, int yPos, int breite, int hoehe, Methodenbox m)
        {
            id = idNeu;
            methodenbox = m;
            icon= new ImageIcon(dateiangabe);
            label = new JLabel(icon);
            label.setLocation(xPos, yPos);
            label.setSize(breite, hoehe);
            label.setVisible(true);
            (m.getContentPane()).add(label);
            m.invalidate();
            m.repaint(1);

        }

        private JLabel gibLabel()
        {
            return label;
        }

        private String gibID()
        {
            return id;
        }

        private void setzeIcon(ImageIcon icon)
        {
            label.setIcon(icon);
        }

        private void setzeGroesse(int breite, int hoehe)
        {
            label.setSize(breite, hoehe);
        }

        private void setzePosition(int xPos, int yPos)
        {
            label.setLocation(xPos, yPos);
        }
    }

    private class Textanzeige
    {
        private String id;
        private JTextArea textfeld;
        private Methodenbox methodenbox;

        Textanzeige(String idNeu, String text, int xPos, int yPos, int breite, int hoehe, Methodenbox m)
        {
            id = idNeu;
            methodenbox = m;
            textfeld = new JTextArea(text);
            textfeld.setLocation(xPos, yPos);
            textfeld.setSize(breite, hoehe);
            textfeld.setLineWrap(true);
            textfeld.setWrapStyleWord(true);
            textfeld.setVisible(true);
            (m.getContentPane()).add(textfeld);
            m.invalidate();
            m.repaint(1);

        }

        private String gibID()
        {
            return id;
        }

        private JTextArea gibTextfeld()
        {
            return textfeld;
        }

        private void setzeText(String text)
        {
            textfeld.setText(text);
        }

        private void setzeGroesse(int breite, int hoehe)
        {
            textfeld.setSize(breite, hoehe);
        }

        private void setzePosition(int xPos, int yPos)
        {
            textfeld.setLocation(xPos, yPos);
        }
    }

}
