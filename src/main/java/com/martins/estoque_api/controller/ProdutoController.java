package com.martins.estoque_api.controller;

import com.martins.estoque_api.dto.ProdutoCreateDTO;
import com.martins.estoque_api.dto.CategoriaDTO;
import com.martins.estoque_api.dto.ProdutoDTO;
import com.martins.estoque_api.model.Categoria;
import com.martins.estoque_api.model.Produto;
import com.martins.estoque_api.service.CategoriaService;
import com.martins.estoque_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<ProdutoDTO> listar() {
        return produtoService.listar()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscar(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toDTO(produto);
    }

    @PostMapping
    public ProdutoDTO criar(@RequestBody ProdutoCreateDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        produto.setCategoria(categoria);

        return toDTO(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Long id, @RequestBody ProdutoCreateDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        produto.setCategoria(categoria);

        return toDTO(produtoService.atualizar(id, produto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @PatchMapping("/{id}/entrada")
    public ProdutoDTO entrada(@PathVariable Long id, @RequestBody QuantidadeRequest req) {
        return toDTO(produtoService.entradaEstoque(id, req.getQuantidade()));
    }

    @PatchMapping("/{id}/saida")
    public ProdutoDTO saida(@PathVariable Long id, @RequestBody QuantidadeRequest req) {
        return toDTO(produtoService.saidaEstoque(id, req.getQuantidade()));
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade());
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(produto.getCategoria().getId());
        categoriaDTO.setNome(produto.getCategoria().getNome());
        dto.setCategoria(categoriaDTO);
        return dto;
    }

    public static class QuantidadeRequest {
        private int quantidade;
        public int getQuantidade() {
            return quantidade;
        }
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }
}
