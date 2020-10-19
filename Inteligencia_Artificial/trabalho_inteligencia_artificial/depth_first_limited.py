class DepthFirstLimited:

    from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho

    caminho = MostraCaminho()
    pais = {}
    visitados = []
    lista = []
    limites = {}

    def depthfirst_limited(self, grafico, start, goalNode, limit):
        if self.busca(grafico, start, goalNode, limit):
            self.caminho.mostra_caminho(start, goalNode, self.pais)
        else:
            print('Não encontrado')

    def busca(self, grafico, start, goalNode, limit, limite=0):

        self.visitados.append(start)
        self.lista.append(start)
        pai = self.lista.pop(0)

        if limite == 0:
            self.limites[pai] = limite

        if pai.__eq__(goalNode):
            return True

        if self.limites[pai] == limit:
            return

        if len(grafico[pai]) > 0:
            limite += 1
            for filho in grafico[pai]:
                if not self.visitados.__contains__(filho):
                    self.limites[filho] = self.limites[pai] + 1
                    self.pais[filho] = pai
                    if self.busca(grafico, filho, goalNode, limit, self.limites[filho]):
                        return True

        return False

