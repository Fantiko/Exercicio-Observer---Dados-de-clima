/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testeview.mavenproject1;

import View.MainPanel;
import Presenter.EstacaoClimatica;

/**
 *
 * @author kaios
 */
public class Main {

    public static void main(String[] args) {

        EstacaoClimatica estacaoClimatica = new EstacaoClimatica();
        MainPanel mainPanel = new MainPanel();
        mainPanel.desktopPaneInit(estacaoClimatica);

    }
}
