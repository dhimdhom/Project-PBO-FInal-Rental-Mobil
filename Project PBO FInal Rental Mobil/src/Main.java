/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import controller.LoginController;
import view.LoginView;

public class Main {

    public static void main(String[] args) {

        LoginView view = new LoginView();

        LoginController controller =
                new LoginController(view);
    }
}