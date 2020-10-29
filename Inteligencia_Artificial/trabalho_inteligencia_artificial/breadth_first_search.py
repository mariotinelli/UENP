class BreadthFirst:

    def __init__(self, grafo, start, goalNode):
        self.visitado = []
        self.listaAdj = []
        self.caminho = {}
        self.grafo = grafo
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        if self.busca_bfs():
            self.caminho_bfs(self.caminho)
        else:
            print("Caminho nao encontrado!")
        self.clear()

    def busca_bfs(self):
        self.visitado.append(self.start)
        self.listaAdj.append(self.start)

        if self.start.__eq__(self.goalNode):
            return True

        while self.listaAdj:
            cidadeAtual = self.listaAdj.pop(0)

            if cidadeAtual.__eq__(self.goalNode):
                return True

            for filho in self.grafo[cidadeAtual]:
                if filho not in self.visitado:
                    self.visitado.append(filho)
                    self.listaAdj.append(filho)
                    self.caminho[filho] = cidadeAtual
        return False

    def caminho_bfs(self, caminho):
        print('Caminho:', end=' ')
        cidadePai = self.goalNode
        while True:
            print(cidadePai, end=" -> ")
            if cidadePai == self.start:
                break
            cidadePai = caminho[cidadePai]

    def clear(self):
        self.visitado.clear()
        self.listaAdj.clear()
        self.caminho.clear()


"""from create_grafo import Grafo

create = Grafo()
BreadthFirst(create.criaGrafo(), "Arad", "Arad").iniciarBusca()"""
