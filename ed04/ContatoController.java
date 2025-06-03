import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class ContatoController {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato contato) {
        for (Contato c : contatos) {
            if (contato instanceof PessoaFisica && c instanceof PessoaFisica) {
                if (((PessoaFisica) c).getCpf().equals(((PessoaFisica) contato).getCpf())) {
                    System.out.println("Contato com este CPF já existe.");
                    return;
                }
            } else if (contato instanceof PessoaJuridica && c instanceof PessoaJuridica) {
                if (((PessoaJuridica) c).getCnpj().equals(((PessoaJuridica) contato).getCnpj())) {
                    System.out.println("Contato com este CNPJ já existe.");
                    return;
                }
            }
        }
        contatos.add(contato);
    }

    public void remover(String id) {
        Iterator<Contato> iterator = contatos.iterator();
        while (iterator.hasNext()) {
            Contato c = iterator.next();
            if (c instanceof PessoaFisica && ((PessoaFisica) c).getCpf().equals(id)) {
                iterator.remove();
                return;
            } else if (c instanceof PessoaJuridica && ((PessoaJuridica) c).getCnpj().equals(id)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }

    public List<Contato> listar() {
        return contatos;
    }
}
