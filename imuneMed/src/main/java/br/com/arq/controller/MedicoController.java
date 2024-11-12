package br.com.arq.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.arq.model.Medico;
import br.com.arq.repository.UsersRepository;

@Controller
public class MedicoController {

	@Autowired
	private UsersRepository repository;

	@GetMapping("/cadastroMedico")
	public String cadastroform() {
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastrar(@RequestParam String email, @RequestParam String name, @RequestParam String password,
			Model model) {
		if (repository.findByEmail(email).isPresent()) {
			model.addAttribute("message", "Email já cadastrado. Tente outro.");
			return "cadastro";
		}

		try {
			Medico medico = new Medico();
			medico.setEmail(email);
			medico.setName(name);
			medico.setPassword(medico.criptografarSenha(password));
			medico resposta = repository.save(medico);
			model.addAttribute("message", "Cadastro realizado com sucesso!");
			return "login";

		} catch (Exception ex) {
			model.addAttribute("message", "Error" + ex.getMessage());
			return "cadastro";
		}
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) throws Exception {
		Optional<Users> optionalUser = repository.findByEmail(email);

		if (optionalUser.isPresent()
				&& optionalUser.get().getPassword().equals(optionalUser.get().criptografarSenha(password))) {
			model.addAttribute("message", "Login realizado com sucesso!");
			return "redirect:/home";
		} else {
			model.addAttribute("message", "Email ou senha inválidos.");
			return "login";
		}
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return "cadastro";
	}

}