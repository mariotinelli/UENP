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
        self.grafico = self.create.criaGrafo()
        self.graficoCusto = self.create.criaGrafoCusto()

    def search(self):
        if self.busca.__eq__('1'):
            bfs = BreadthFirst(self.grafico, self.start, self.goalNode)
            bfs.iniciarBusca()

        elif self.busca.__eq__('2'):
            dj = Dijkstra(self.graficoCusto, self.start, self.goalNode)
            dj.iniciarBusca()

        elif self.busca.__eq__('3'):
            df = DepthFirst(self.grafico, self.start, self.goalNode)
            df.iniciarBusca()

        elif self.busca.__eq__('4'):
            dfl = DepthFirstLimited(self.grafico, self.start, self.goalNode)
            dfl.iniciarBusca()

        elif self.busca.__eq__('5'):
            ids = IterativeDeepeningSearch(self.grafico, self.start, self.goalNode)
            ids.iniciarBusca()

        print(' \n ')


if __name__ == '__main__':

    Grafo().printGrafo(Grafo().criaGrafoCusto())
    print('\n')
    
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
