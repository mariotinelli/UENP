from mostra_caminho import MostraCaminho


class DepthFirstLimited:

    def __init__(self, grafo, start, goalNode):
        self.limit = int(input('Digite um limite para sua busca: '))
        self.mostraCaminho = MostraCaminho()
        self.caminho = {}
        self.visitados = []
        self.listaAdj = []
        self.limites = {start: 0}
        self.grafo = grafo
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.depthfirst_limited()
        self.clear()

    def depthfirst_limited(self):
        if self.busca(self.start):
            self.mostraCaminho.mostra_caminho(self.start, self.goalNode, self.caminho)
        else:
            print('Não encontrado')

    def busca(self, start, limite=0):

        self.visitados.append(start)
        self.listaAdj.append(start)
        cidadeAtual = self.listaAdj.pop(0)

        if cidadeAtual.__eq__(self.goalNode):
            return True

        if self.limites[cidadeAtual] == self.limit:  # Chegou no limite escolhido.
            return

        if len(self.grafo[cidadeAtual]) > 0:
            limite += 1
            for filho in self.grafo[cidadeAtual]:
                if not self.visitados.__contains__(filho):
                    self.limites[filho] = self.limites[cidadeAtual] + 1
                    self.caminho[filho] = cidadeAtual
                    if self.busca(filho, self.limites[filho]):
                        return True

        return False

    def clear(self):
        self.listaAdj.clear()
        self.caminho.clear()
        self.visitados.clear()
        self.limites.clear()

"""
from create_grafo import Grafo
create = Grafo()
DepthFirstLimited(create.criaGrafo(), "Arad", "Bucharest").iniciarBusca()
"""