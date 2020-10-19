
from trabalho_inteligencia_artificial.depth_first_limited import DepthFirstLimited
from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho


class IterativeDeepeningSearch:

    dfl = DepthFirstLimited()
    caminho = MostraCaminho()

    def iterative_search(self, grafico, start, goalNode, limit):
        if self.busca(grafico, start, goalNode, limit):
            self.caminho.mostra_caminho(start, goalNode, self.dfl.pais)
        else:
            print('Não encontrado')

    def busca(self, grafico, start, goalNode, limit):
        for i in range(limit):
            if self.dfl.busca(grafico, start, goalNode, limit):
                return True
        return False
