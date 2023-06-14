package com.ssssssl;

import javax.smartcardio.*;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.Signature;
import java.util.List;
import java.security.*;
import java.util.Scanner;

/**
 * @author YeeDer
 * @since 2023/2/18 下午 05:57
 **/
public class TestSign_SmartCard {
    public static void main(String[] args) throws Exception {
        TerminalFactory factory = TerminalFactory.getDefault();
        CardTerminals terminals = factory.terminals();
        List<CardTerminal> list = terminals.list();
        System.out.println("Available Readers:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i).getName());
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Select Reader: ");
        int choice = input.nextInt();
        CardTerminal terminal = list.get(choice - 1);
        System.out.println("Insert Smart Card...");
        Card card = terminal.connect("*");
        System.out.println("Smart Card: " + card);
        CardChannel channel = card.getBasicChannel();

        byte[] apdu = new byte[]{
                (byte) 0x00, // CLA (Class)
                (byte) 0xA4, // INS (Instruction)
                (byte) 0x04, // P1  (Parameter 1)
                (byte) 0x00, // P2  (Parameter 2)
                (byte) 0x08, // Lc  (Data length)
                (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x54, (byte) 0x48, (byte) 0x00, (byte) 0x01
        };


        ResponseAPDU response = channel.transmit(new CommandAPDU(apdu));
        System.out.println("response.getSW2() = " + response.getSW2());
        byte[] signature = response.getData();
        System.out.println("Signature: " + bytesToHex(signature));
    }



//    public static void main(String[] args) {
//        try {
//            // 取得智慧卡
//            TerminalFactory tf = TerminalFactory.getDefault();
//            CardTerminals ct = tf.terminals();
//            List<CardTerminal> readers = ct.list(CardTerminals.State.CARD_PRESENT);
//            CardTerminal terminal = readers.get(0);
//            Card card = terminal.connect("*");
//            CardChannel channel = card.getBasicChannel();
//
//            // 設定簽章物件
//            Signature signature = Signature.getInstance("SHA256withRSA");
//            PrivateKey privateKey = getPrivateKey(Card card); // 取得私鑰
//            signature.initSign(privateKey);
//
//            // 準備簽章資料
//            byte[] data = "Hello, World!".getBytes();
//
//            // 建立 APDU 指令
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            DataOutputStream dos = new DataOutputStream(baos);
//            dos.writeInt(data.length);
//            dos.write(data);
//            dos.writeInt(signature.getAlgorithm().length());
//            dos.write(signature.getAlgorithm().getBytes());
//            byte[] apduData = baos.toByteArray();
//
//            CommandAPDU apdu = new CommandAPDU(
//                    0x00, // CLA
//                    0x01, // INS
//                    0x00, // P1
//                    0x00, // P2
//                    apduData // Lc/Data
//            );
//
//            // 傳送指令並取得回應
//            ResponseAPDU response = channel.transmit(apdu);
//
//            // 檢查回應是否成功
//            if (response.getSW() != 0x9000) {
//                throw new Exception("Failed to sign data");
//            }
//
//            // 取得簽章結果
//            byte[] signatureBytes = response.getData();
//
//            // 將簽章結果轉成十六進位字串印出
//            System.out.println("Signature: " + bytesToHex(signatureBytes));
//
//            // 關閉智慧卡
//            card.disconnect(false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static PrivateKey getPrivateKey() throws Exception {
        // TODO: 實作取得私鑰的方法
        return null;
    }

    // 將 byte[] 轉成十六進位字串
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
