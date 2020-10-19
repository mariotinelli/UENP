
class BreadthFirst:

    visitado = []
    lista = []

    def busca_bfs(self, visitado, grafico, start, goalNode):
        visitado.append(start)
        self.lista.append(start)
        nosPai = {start: []}
        caminho = [[goalNode]]

        if start.__eq__(goalNode):
            return caminho

        while self.lista:
            s = self.lista.pop(0)
            self.lista.append(s)

            if s.__eq__(goalNode):
                break

            for vizinho in grafico[s]:
                if vizinho not in visitado:
                    visitado.append(vizinho)
                    self.lista.append(vizinho)
                    nosPai[vizinho] = [s]
        pai = nosPai[goalNode]
        while True:
            caminho.append(pai)
            if pai.__getitem__(0).__eq__(start):
                break
            pai = nosPai[pai.__getitem__(0)]

        self.caminho_bfs(caminho)

    def caminho_bfs(self, caminho):
        print('Caminho:', end=' ')
        for i in reversed(range(len(caminho))):
            if i > 0:
                print(caminho[i].__getitem__(0), '-->', end=' ')
            else:
                print(caminho[i].__getitem__(0), end=' ')
