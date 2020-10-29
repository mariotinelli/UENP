
from depth_first_limited import DepthFirstLimited
from mostra_caminho import MostraCaminho


class IterativeDeepeningSearch:

    def __init__(self, grafo, start, goalNode):
        self.grafo = grafo
        self.start = start
        self.goalNode = goalNode
        self.mostraCaminho = MostraCaminho()
        self.dfl = DepthFirstLimited(self.grafo, self.start, self.goalNode)
        self.limit = self.dfl.limit

    def iniciarBusca(self):
        self.iterative_search()
        self.dfl.clear()

    def iterative_search(self):
        if self.busca(self.start):
            self.mostraCaminho.mostra_caminho(self.start, self.goalNode, self.dfl.caminho)
        else:
            print('Não encontrado')

    def busca(self, start):
        for i in range(self.limit):
            if self.dfl.busca(start):
                return True
        return False


"""from create_grafo import Grafo
create = Grafo()
IterativeDeepeningSearch(create.criaGrafo(), "Arad", "Bucharest").iniciarBusca()"""