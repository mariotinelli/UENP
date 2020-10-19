from trabalho_inteligencia_artificial.breadth_first_search import BreadthFirst
from trabalho_inteligencia_artificial.create_grafo import Grafo
from trabalho_inteligencia_artificial.dijkstra_search import Dijkstra
from trabalho_inteligencia_artificial.depth_first_search import DepthFirst
from trabalho_inteligencia_artificial.depth_first_limited import DepthFirstLimited
from trabalho_inteligencia_artificial.depth_first_iterative import IterativeDeepeningSearch


class Busca:

    def __init__(self, entrada, busca):
        self.start = entrada.split()[0]
        self.goalNode = entrada.split()[1]
        self.busca = busca
        self.create = Grafo()

    def search(self):
        if self.busca.__eq__('1'):
            grafico = self.create.criaGrafo()
            bfs = BreadthFirst()
            bfs.busca_bfs(bfs.visitado, grafico, self.start, self.goalNode)
            bfs.visitado.clear()

        elif self.busca.__eq__('2'):
            grafico = self.create.criaGrafoCusto()
            dj = Dijkstra()
            dj.dijkstra(grafico, self.start, self.goalNode)
            dj.visitados.clear()

        elif self.busca.__eq__('3'):
            df = DepthFirst()
            grafico = self.create.criaGrafo()
            df.depth_first(grafico, self.start, self.goalNode)
            df.visitados.clear()

        elif self.busca.__eq__('4'):
            limit = int(input('Digite um limite para sua busca: '))
            limit = int(limit)
            dfl = DepthFirstLimited()
            grafico = self.create.criaGrafo()
            dfl.depthfirst_limited(grafico, self.start, self.goalNode, limit)
            dfl.visitados.clear()

        elif self.busca.__eq__('5'):
            limit = int(input('Digite um limite para sua busca: '))
            limit = int(limit)
            ids = IterativeDeepeningSearch()
            grafico = self.create.criaGrafo()
            ids.iterative_search(grafico, self.start, self.goalNode, limit)
            ids.dfl.visitados.clear()

        print(' \n ')


if __name__ == '__main__':

    while True:

        entrada = input("Digite o estado que deseja sair e para qual estado deseja ir: ")

        busca = input("Digite o tipo de busca de deseja fazer \n "
                      "-> 1 - BFS \n "
                      "-> 2 - Dijkstra \n "
                      "-> 3 - Depth-First \n "
                      "-> 4 - DepthFirstLimited \n "
                      "-> 5 - IterativeDeepeningSearch \n "
                      "Entrada: ")

        s = Busca(entrada, busca)
        s.search()
