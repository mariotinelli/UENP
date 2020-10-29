

class MostraCaminho:

    def mostra_caminho(self, start, goalNode, caminho):

        print('Caminho:', end=' ')
        cidadePai = goalNode
        while True:
            print(cidadePai, end=" -> ")
            if cidadePai == start:
                break
            cidadePai = caminho[cidadePai]
