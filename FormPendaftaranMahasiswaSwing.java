package tugas8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPendaftaranMahasiswaSwing extends JFrame implements ActionListener {
    private JTextField tfNama, tfTanggalLahir, tfNoPendaftaran, tfNoTelp, tfAlamat, tfEmail;
    private JButton btnSubmit;

    public FormPendaftaranMahasiswaSwing() {
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Nama Lengkap"));
        tfNama = new JTextField();
        add(tfNama);

        add(new JLabel("Tanggal Lahir"));
        tfTanggalLahir = new JTextField();
        add(tfTanggalLahir);

        add(new JLabel("Nomor Pendaftaran"));
        tfNoPendaftaran = new JTextField();
        add(tfNoPendaftaran);

        add(new JLabel("No. Telp"));
        tfNoTelp = new JTextField();
        add(tfNoTelp);

        add(new JLabel("Alamat"));
        tfAlamat = new JTextField();
        add(tfAlamat);

        add(new JLabel("E-mail"));
        tfEmail = new JTextField();
        add(tfEmail);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            if (tfNama.getText().isEmpty() || tfTanggalLahir.getText().isEmpty() ||
                tfNoPendaftaran.getText().isEmpty() || tfNoTelp.getText().isEmpty() ||
                tfAlamat.getText().isEmpty() || tfEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin data sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    showData();
                }
            }
        }
    }

    private void showData() {
        JFrame frame = new JFrame("Data Mahasiswa");
        JTextArea taData = new JTextArea();
        taData.setText(
                "Nama: " + tfNama.getText() + "\n" +
                "Tanggal Lahir: " + tfTanggalLahir.getText() + "\n" +
                "Nomor Pendaftaran: " + tfNoPendaftaran.getText() + "\n" +
                "No. Telp: " + tfNoTelp.getText() + "\n" +
                "Alamat: " + tfAlamat.getText() + "\n" +
                "E-mail: " + tfEmail.getText());

        frame.add(new JScrollPane(taData));
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FormPendaftaranMahasiswaSwing();
    }
}
