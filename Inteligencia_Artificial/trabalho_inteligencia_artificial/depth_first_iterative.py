
from trabalho_inteligencia_artificial.depth_first_limited import DepthFirstLimited
from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho


class IterativeDeepeningSearch:

    def __init__(self, grafico, start, goalNode):
        self.grafico = grafico
        self.start = start
        self.goalNode = goalNode
        self.caminho = MostraCaminho()
        self.limit = int(input('Digite um limite para sua busca: '))
        self.dfl = DepthFirstLimited(self.grafico, self.start, self.goalNode, self.limit)

    def iniciarBusca(self):
        self.iterative_search()
        self.dfl.clear()

    def iterative_search(self):
        if self.busca(self.start):
            self.caminho.mostra_caminho(self.start, self.goalNode, self.dfl.pais)
        else:
            print('Não encontrado')

    def busca(self, start):
        for i in range(self.limit):
            if self.dfl.busca(start):
                return True
        return False
