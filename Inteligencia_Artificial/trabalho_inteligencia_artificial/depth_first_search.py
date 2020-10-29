
from mostra_caminho import MostraCaminho


class DepthFirst:

    def __init__(self, grafo, start, goalNode):
        self.mostraCaminho = MostraCaminho()
        self.caminho = {}
        self.visitados = []
        self.listaAdj = []
        self.grafo = grafo
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.depth_first()
        self.clear()

    def depth_first(self):

        if self.busca(self.start):
            self.mostraCaminho.mostra_caminho(self.start, self.goalNode, self.caminho)
        else:
            print('Não encontrado')

    def busca(self, start):

        self.visitados.append(start)
        self.listaAdj.append(start)
        cidadeAtual = self.listaAdj.pop(0)

        if cidadeAtual.__eq__(self.goalNode):
            return True

        for filho in self.grafo[cidadeAtual]:
            if not self.visitados.__contains__(filho):
                self.caminho[filho] = cidadeAtual
                if self.busca(filho):
                    return True
        return False

    def clear(self):
        self.caminho.clear()
        self.visitados.clear()
        self.listaAdj.clear()


"""from create_grafo import Grafo
create = Grafo()
DepthFirst(create.criaGrafo(), "Arad", "Bucharest").iniciarBusca()"""