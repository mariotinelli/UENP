

class MostraCaminho:

    def mostra_caminho(self, start, goalNode, pais):

        caminho = []
        pai = pais[goalNode]
        caminho.append(goalNode)

        while True:
            caminho.append(pai)
            if pai.__eq__(start):
                break
            pai = pais[pai]

        for i in reversed(range(len(caminho))):
            if i > 0:
                print(caminho[i], '-->', end=' ')
            else:
                print(caminho[i], end=' ')