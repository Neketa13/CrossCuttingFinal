package GUI;

import Archive.ZipArchiving;
import Encryption.Decryptor;
import Encryption.Encryptor;
import TestsandParsing.Parsing;
import WorkWithFiles.WorkWithJSON;
import WorkWithFiles.WorkWithTxt;
import WorkWithFiles.WorkWithXML;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

public class Reader extends JFrame {
    ArrayList<String>list=new ArrayList<String>();
    ArrayList<String>newList=new ArrayList<String>();
    String getValue;
    JButton b1,b2,b3,b4,b5;
    JLabel l1, l2;
    JTextField t1, t2;
    //JRadioButton r1, r2, r3;

    //eHandler handler = new eHandler();

    public Reader(String s) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, SAXException, XMLStreamException, ParserConfigurationException, ParseException, TransformerException {
        super(s);
        WorkWithJSON json=new WorkWithJSON();
        WorkWithTxt txt=new WorkWithTxt();
        WorkWithXML xml=new WorkWithXML();
        Parsing parsing=new Parsing();
        ZipArchiving zip=new ZipArchiving();
        File src = new File("D:/Java_laba/Cross-CuttingTask/input");
        File dst =new File("D:/Java_laba/Cross-CuttingTask/output");
        Encryptor en = Encryptor.getEncrypter(true);
        Decryptor de = Decryptor.getDecrypter(true);
        setLayout(new FlowLayout());
        b1 = new JButton("ВЫПОЛНИТЬ");
        b2 = new JButton("РАЗАРХИВИРОВАТЬ");
        b4 = new JButton("ЗАШИФРОВАТЬ");
        b3 = new JButton("ЗААРХИВИРОВАТЬ");
        b5 = new JButton("РАСШИФРОВАТЬ");
        t1=new JTextField(10);
        t2=new JTextField(10);

        l1 = new JLabel("Введите название входного файла:");
        l2 = new JLabel("Введите название выходного:");


        add(l1);
        l1.setBackground(Color.cyan);
        add(t1);


        ActionListener listener1=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(getFileExtension(t1.getText()).equals("txt")) {
                    try {
                        list = txt.read(t1.getText());
                    } catch (IOException | ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        newList=parsing.FileParsing(list);
                    } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException |
                             InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException |
                             InvalidKeyException | XMLStreamException | ParserConfigurationException |
                             TransformerException | SAXException | ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(getFileExtension(t1.getText()).equals("json")) {
                    try {
                        list = json.read(t1.getText());
                    } catch (IOException | ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        newList=parsing.FileParsing(list);
                    } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException |
                             InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException |
                             InvalidKeyException | XMLStreamException | ParserConfigurationException |
                             TransformerException | SAXException | ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                    if(getFileExtension(t1.getText()).equals("xml"))
                    {
                        try {
                            list=xml.read(t1.getText());
                        } catch (IOException | ParserConfigurationException | SAXException | ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            newList=parsing.FileParsing(list);
                        } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException |
                                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException |
                                 InvalidKeyException | XMLStreamException | ParserConfigurationException |
                                 TransformerException | SAXException | ParseException ex) {
                            throw new RuntimeException(ex);
                        }
//
                    }
                if(getFileExtension(t2.getText()).equals("txt")) {
                    try {
                        txt.write(newList,t2.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(getFileExtension(t2.getText()).equals("json")) {
                    try {
                        json.write(newList,t2.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if(getFileExtension(t2.getText()).equals("xml")){
                    try {
                        xml.write(newList,t2.getText());
                    } catch (IOException | XMLStreamException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                }
        };
        add(l2);
        add(t2);
        b1.addActionListener(listener1);

        ActionListener listener2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zip.deArchiving(t1.getText());
            }
        };
        b2.addActionListener(listener2);
        add(b2);
//        add(b1);

        ActionListener listener3=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zip.archiving(t2.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b3.addActionListener(listener3);
        add(b3);
        add(b1);

        ActionListener listener4=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                en.encrypt(new File(t1.getText()),dst);
            }
        };
        b4.addActionListener(listener4);
        add(b4);

        ActionListener listener5=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                de.decrypt(new File(t2.getText()),src);
            }
        };
        b5.addActionListener(listener5);
        add(b5);

    }
    private String getFileExtension(String str) {
        //String fileName = file.getName();
        if(str.lastIndexOf(".") != -1 && str.lastIndexOf(".") != 0)
            return str.substring(str.lastIndexOf(".")+1);
        else return "";
    }
}