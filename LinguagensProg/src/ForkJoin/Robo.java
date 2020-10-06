/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;



public class Robo {
    public static long contar(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        return (contar(x - 1, y) + contar(x, y - 1));
    }
}
