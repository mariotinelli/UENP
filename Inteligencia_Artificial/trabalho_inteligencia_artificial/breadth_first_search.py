
class BreadthFirst:

    def __init__(self, grafico, start, goalNode):
        self.visitado = []
        self.lista = []
        self.grafico = grafico
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.busca_bfs()
        self.clear()

    def busca_bfs(self):
        self.visitado.append(self.start)
        self.lista.append(self.start)
        nosPai = {self.start: []}
        caminho = [[self.goalNode]]

        if self.start.__eq__(self.goalNode):
            return caminho

        while self.lista:
            s = self.lista.pop(0)
            self.lista.append(s)

            if s.__eq__(self.goalNode):
                break

            for vizinho in self.grafico[s]:
                if vizinho not in self.visitado:
                    self.visitado.append(vizinho)
                    self.lista.append(vizinho)
                    nosPai[vizinho] = [s]
        pai = nosPai[self.goalNode]
        while True:
            caminho.append(pai)
            if pai.__getitem__(0).__eq__(self.start):
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

    def clear(self):
        self.visitado.clear()
        self.lista.clear()
