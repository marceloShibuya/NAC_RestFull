package br.com.fiap.action;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.VendaBO;
import br.com.fiap.to.VendaTO;
 
/**
 * Servlet implementation class VendaAction
 */
@WebServlet(urlPatterns = { "/VendaAction", "/listagem", "/listar", "/adicionar", "/alterar", "/remover"})
public class VendaAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VendaBO vbo = new VendaBO(); 
    private VendaTO venda = null;
       
    
    public VendaAction() {
        super();
    }
 
    
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        if (req.getRequestURI().equals("/MarceloShibuya83752Client/listagem")) {
 
            listagem(req, res);
 
        } else if (req.getRequestURI().equals("/MarceloShibuya83752Client/listar")) {
 
            listar(req, res);
 
        } else if (req.getRequestURI().equals("/MarceloShibuya83752Client/adicionar")) {
            
            adicionar(req, res);
            
        } else if (req.getRequestURI().equals("/MarceloShibuya83752Client/remover")) {
            
            remover(req, res);
            
        } else if (req.getRequestURI().equals("/MarceloShibuya83752Client/alterar")) {
 
            alterar(req, res);
            
        }
        
        
        
    }
    
    
    protected void listagem(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
        VendaTO[] vto = vbo.listagem();
        
        req.setAttribute("listaVendas", vto);
        
        req.setAttribute("controle", "lista-vendas");
        
        req.setAttribute("action-frm", "adicionar");
        
        req.getRequestDispatcher("index.jsp").forward(req, res);
        
    }
    
    
    protected void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
        int cod = Integer.parseInt(req.getParameter("codProd"));
        
        VendaTO vto = vbo.listagem(cod);
        
        req.setAttribute("vendaObj", vto);
        
        req.setAttribute("action_frm", "alterar");
        
        req.getRequestDispatcher("index.jsp").forward(req, res);
        
    }
    
    
    protected void adicionar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
        venda = new VendaTO();
		
        venda.setCodigo(Integer.parseInt(req.getParameter("txtCodVenda")));
        venda.setNome(req.getParameter("txtNomeCliente"));
        venda.setDtVenda(Calendar.getInstance());
        venda.setDescricao(req.getParameter("txtDesc"));
        venda.setValor(Double.parseDouble(req.getParameter("txtVl")));
        venda.setStatus(Boolean.parseBoolean(req.getParameter("txtSituacaoPag")));
        
        vbo = new VendaBO();
        vbo.cadastrar(venda);
        
        req.setAttribute("controle", "lista-vendas");
 
        req.setAttribute("action-frm", "adicionar");
        
        req.getRequestDispatcher("listagem").forward(req, res);
        
        
    }
    
    
    protected void alterar (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
    	  venda = new VendaTO();
          //venda.setCodigo(Integer.parseInt(req.getParameter("txtCodVenda")));
            venda.setNome(req.getParameter("txtNomeCliente"));
          //venda.setDtVenda(Calendar.getInstance());
            venda.setDescricao(req.getParameter("txtDesc"));
            venda.setValor(Double.parseDouble(req.getParameter("txtVl")));
          //venda.setStatus(Boolean.parseBoolean(req.getParameter("txtSituacaoPag")));
        
        vbo = new VendaBO();
        vbo.atualizar(venda);
        
        req.setAttribute("controle", "lista-vendas");
 
        req.setAttribute("action-frm", "adicionar");
        
        req.getRequestDispatcher("listagem").forward(req, res);
        
    }
    
    
    protected void remover (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
        int cod = Integer.parseInt(req.getParameter("codProd"));
        
        vbo.excluir(cod);
        
        req.setAttribute("controle", "lista-vendas");
        
        req.setAttribute("action-frm", "adicionar");
        
        req.getRequestDispatcher("listagem").forward(req, res);
        
    }
    
    
 
}
 