package pack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Crud extends JFrame {

    static int countt=1;
    static int roww=0;
    static int max;
    static int min=0;
    static int step=1;
    JButton count;
    JButton left;
    JButton right;
    static JTable crudtable;
    static JTable crudtable1;
    static DefaultTableModel model = new DefaultTableModel();

    static List<Sinhvien> sinhviens = new ArrayList<Sinhvien>();

    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/sinhvien";
    static String USER_NAME = "root";
    static String PASSWORD = "";

    public static void main(String[] args) {

        //List<City> city = new ArrayList<City>();

            Crud crud = new Crud();
            crud.setVisible(true);





        try{
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();
            String sql = "select * from sinhvien";

            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {

                int idsv = rs.getInt("idsv");
                String tensv = rs.getNString("tensv");
                int idlop = rs.getInt("idlop");
                Date ngaysinh = rs.getDate("ngaysinh");

                roww+=1;
                Sinhvien sv = new Sinhvien(idsv,tensv,idlop,ngaysinh);

                sinhviens.add(sv);
               // addrow(sv);
            }
            for(Sinhvien sinhvien:sinhviens)
            addrow(sinhvien);
            max= ((roww-1)/step)+1;
            showtable(min,step);


      } catch (
    SQLException e) {
        System.out.println("connect failure!");
        e.printStackTrace();
    }

    }

    public Crud()
    {
        setBounds(300, 100, 1000, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();


        SpringLayout sl_contentPane = new SpringLayout();
        panel1.setLayout(sl_contentPane);

//        JLabel lblog = new JLabel("T???nh/Th??nh ph???");
//        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,12));
//        sl_contentPane.putConstraint(SpringLayout.EAST, lblog, 110, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.NORTH, lblog, 10, SpringLayout.WEST, panel1);
//        panel1.add(lblog);
//
//        JLabel lbid = new JLabel("Id");
//        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbid, 610, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, lbid, 110, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.NORTH, lbid, 10, SpringLayout.WEST, panel1);
//        panel1.add(lbid);
//
//        JLabel lbsname = new JLabel("T??n t??m t???t");
//        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbsname, 610, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, lbsname, 380, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.NORTH, lbsname, 10, SpringLayout.WEST, panel1);
//        panel1.add(lbsname);
//
//
//
//
//        JLabel lbarea = new JLabel("Khu v???c");
//        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbarea, 810, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, lbarea, 110, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.NORTH, lbarea, 10, SpringLayout.WEST, panel1);
//        panel1.add(lbarea);
//
//        JLabel lbname = new JLabel("T??n");
//        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbname, 810, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, lbname, 380, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.NORTH, lbname, 10, SpringLayout.WEST, panel1);
//        panel1.add(lbname);
//
//        JTextField tfname = new JTextField();
//        JScrollPane scrollPane2 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane2, 390, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane2, -90, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane2, 395, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane2, -420, SpringLayout.EAST, panel1);;
//
//        panel1.add(scrollPane2);
//        scrollPane2.setViewportView(tfname);
//
//
//        JTextField tfsname = new JTextField();
//        JScrollPane scrollPane5 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane5, 300, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane5, -180, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane5, 395, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane5, -420, SpringLayout.EAST, panel1);;
//
//        panel1.add(scrollPane5);
//        scrollPane5.setViewportView(tfsname);
//
//        JTextField tfarea = new JTextField();
//        JScrollPane scrollPane6 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane6, 390, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane6, -90, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane6, 125, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane6, -720, SpringLayout.EAST, panel1);;
//
//        panel1.add(scrollPane6);
//        scrollPane6.setViewportView(tfarea);
//
//
//        JTextField tfflag = new JTextField();
//        JScrollPane scrollPane7 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane7, 300, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane7, -180, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane7, 125, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane7, -720, SpringLayout.EAST, panel1);;
//
//        panel1.add(scrollPane7);
//        scrollPane7.setViewportView(tfflag);




         crudtable = new JTable(model);

        model.addColumn("ID Sinh vi??n ");
        model.addColumn("T??n sinh vi??n");
        model.addColumn("ID L???p");
        model.addColumn("Ng??y sinh");




        Setboundtable(crudtable);




        JScrollPane scrollPane4 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane4, 50, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane4, -300, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane4, 30, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane4, -170, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane4);
        scrollPane4.setViewportView(crudtable);

//        JButton delete = new JButton("X??a");
//        delete.setBackground(Color.pink);
//        delete.setForeground(Color.WHITE);
//        JScrollPane scrollPane3 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane3, 50, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane3, -420, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane3, 830, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane3, -50, SpringLayout.EAST, panel1);;
//        scrollPane3.setViewportView(delete);
//        panel1.add(scrollPane3);
//
//        JButton fix = new JButton("S???a");
//        fix.setBackground(Color.pink);
//        fix.setForeground(Color.WHITE);
//        JScrollPane scrollPane1 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane1, 110, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane1, -360, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane1, 830, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane1, -50, SpringLayout.EAST, panel1);;
//        scrollPane1.setViewportView(fix);
//        panel1.add(scrollPane1);
//
//        JButton ok = new JButton("Ok");
//        ok.setBackground(Color.pink);
//        ok.setForeground(Color.WHITE);
//        JScrollPane scrollPane8 = new JScrollPane();
//        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane8, 170, SpringLayout.NORTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane8, -300, SpringLayout.SOUTH, panel1);
//        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane8, 830, SpringLayout.WEST, panel1);
//        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane8, -50, SpringLayout.EAST, panel1);
//
//        scrollPane8.setViewportView(ok);
//        panel1.add(scrollPane8);


//        delete.setVisible(false);
//        fix.setVisible(false);
//        ok.setVisible(false);

        left = new JButton("<");

        JScrollPane scrollPane9 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane9, 230, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane9, -250, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane9, 200, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane9, -650, SpringLayout.EAST, panel1);
        scrollPane9.setViewportView(left);
        panel1.add(scrollPane9);


        count = new JButton(String.valueOf(countt));

        JScrollPane scrollPane29 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane29, 230, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane29, -250, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane29, 360, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane29, -550, SpringLayout.EAST, panel1);
        scrollPane29.setViewportView(count);
        panel1.add(scrollPane29);

        count.setForeground(Color.pink);


        right = new JButton(">");
        JScrollPane scrollPane19 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane19, 230, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane19, -250, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane19, 450, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane19, -400, SpringLayout.EAST, panel1);
        scrollPane19.setViewportView(right);
        panel1.add(scrollPane19);

        JComboBox CBBday = new JComboBox();
        CBBday.addItem("1 b???ng/trang");
        CBBday.addItem("2 b???ng/trang");
        CBBday.addItem("3 b???ng/trang");
        CBBday.addItem("4 b???ng/trang");
        JScrollPane scrollPane11 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane11, 230, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane11, -250, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane11, 620, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane11, -240, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane11);
        scrollPane11.setViewportView(CBBday);

        CBBday.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                step=CBBday.getSelectedIndex()+1;
                min=0;
                max= ((roww-1)/step)+1;
                countt=1;
                count.setText(String.valueOf(countt));
                setVisiblebtn();
                showtable(min,step);

              //  JOptionPane.showMessageDialog(null,max);
            }
        });

        ListSelectionModel slmodel = crudtable.getSelectionModel();
        slmodel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(! slmodel.isSelectionEmpty())
                {
                    int id;
//                    delete.setVisible(true);
//                    fix.setVisible(true);

                  //  JOptionPane.showMessageDialog(null,"a");
                   // model.addRow(new Object[] {id});
                }
            }
        });



        this.add(panel1);

//        delete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int[] selectedRow = crudtable.getSelectedRows();
//                deleterow(crudtable.getModel().getValueAt(selectedRow[0], 0).toString());
//                model.removeRow(selectedRow[0]);
//                tfarea.setText("");
//                tfflag.setText("");
//                tfname.setText("");
//                tfsname.setText("");
//                delete.setVisible(false);
//                fix.setVisible(false);
//                ok.setVisible(false);
//            }
//        });
//
//        fix.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int[] selectedRow = crudtable.getSelectedRows();
//                tfflag.setText(crudtable.getModel().getValueAt(selectedRow[0], 4).toString());
//                tfsname.setText(crudtable.getModel().getValueAt(selectedRow[0], 1).toString());
//                tfname.setText(crudtable.getModel().getValueAt(selectedRow[0], 2).toString());
//                tfarea.setText(crudtable.getModel().getValueAt(selectedRow[0], 3).toString());
//                ok.setVisible(true);
//            }
//        });
//
//        ok.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int[] selectedRow = crudtable.getSelectedRows();
//
//
//                updaterow(crudtable.getModel().getValueAt(selectedRow[0],0).toString(),tfsname.getText(),tfname.getText(),tfarea.getText(),tfflag.getText());
//                crudtable.setValueAt(tfsname.getText(),selectedRow[0],1);
//                crudtable.setValueAt(tfname.getText(),selectedRow[0],2);
//                crudtable.setValueAt(tfarea.getText(),selectedRow[0],3);
//                crudtable.setValueAt(tfflag.getText(),selectedRow[0],4);
//                tfarea.setText("");
//                tfflag.setText("");
//                tfname.setText("");
//                tfsname.setText("");
//                delete.setVisible(false);
//                fix.setVisible(false);
//                ok.setVisible(false);
//            }
//        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countt--;
                count.setText(String.valueOf(countt));
                setVisiblebtn();
                min-=step;
                showtable(min,step);

            }
        });

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countt++;
                count.setText(String.valueOf(countt));
                setVisiblebtn();
                min+=step;
                showtable(min,step);

            }
        });
        setVisiblebtn();

    }

    public void Setboundtable(JTable tb)
    {
        tb.setRowHeight(35);
        TableColumn column = null;
        for (int i = 0;i <4;i++)
        {
            column = tb.getColumnModel().getColumn(i);
            if(i==2)
            {
                column.setPreferredWidth(100);
            }
            else
            {
                column.setPreferredWidth(50);
            }
        }
    }

    static public void addrow(Sinhvien sv)
    {
        model.addRow(new Object[] {sv.idsv,sv.tensv,sv.idlop,sv.ngaysinh});

    }

    public void deleterow(String key) {
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();

            String sql1 = "DELETE FROM crudd WHERE id = "+key ;
            myStmt.executeUpdate(sql1);
        } catch (
                SQLException e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
    }
    public void updaterow(String key,String sname,String name,String area,String flag)
    {
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();

            String sql1 = "UPDATE crudd " +
                          "SET sname = '"+sname+ "', "
                              +"namee = '"+name+ "', "
                              +"area = '"+area+ "', "
                              +"flag = '"+flag+ "' "
                              +"WHERE id = "+key;

            myStmt.executeUpdate(sql1);
        } catch (
                SQLException e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
    }


    public void setVisiblebtn()
    {
        if (countt==1)
        {
            left.setEnabled(false);
        }
        else
        {
            left.setEnabled(true);
        }

        if (countt==max)
        {

            right.setEnabled(false);
        }
        else
        {
            right.setEnabled(true);
        }
    }

    static public void showtable(int min,int step)
    {
        DefaultTableModel model1 = new DefaultTableModel();

        model1.addColumn("ID Sinh vi??n ");
        model1.addColumn("T??n sinh vi??n");
        model1.addColumn("ID L???p");
        model1.addColumn("Ng??y sinh");
        if (min<roww-step)
        for (int i=min;i<=min+step-1;i++)
        {
            model1.addRow(new Object[] { model.getValueAt(i,0), model.getValueAt(i,1),model.getValueAt(i,2)
            , model.getValueAt(i,3)});

        }
        else
        {
            if (min==roww-1)
            {
                model1.addRow(new Object[] { model.getValueAt(min,0), model.getValueAt(min,1),model.getValueAt(min,2)
                        , model.getValueAt(min,3)});
            }
            else
            {
                for (int i=min;i<=roww-1;i++)
                {
                    model1.addRow(new Object[] { model.getValueAt(i,0), model.getValueAt(i,1),model.getValueAt(i,2)
                            , model.getValueAt(i,3)});

                }
            }

        }

        crudtable.setModel(model1);


    }
}
