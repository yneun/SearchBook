package com.crud.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.book.con.*;
import com.crud.user.UserVO;

/**
 * Handles requests for the application board.
 */
@Controller
public class UserController {
	
	@Autowired
	BoardDAO boardService;
	
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/user/addaccount", method = RequestMethod.GET)
	public String addPost() {
		return "addaccount";
	}
	
	@RequestMapping(value = "/user/addccount_ok", method = RequestMethod.POST)
	public String addPostOK(UserVO vo) {
		int i = UserService.insertBoard(vo);
		if(i == 0)
			System.out.println("Failed to add data");
		else
			System.out.println("Successfully added data!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/editpost/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "editform";
	}
	
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOK(BoardVO vo) {
		int i = boardService.updateBoard(vo);
		if(i == 0)
			System.out.println("Failed to add data");
		else
			System.out.println("Successfully added data!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deltePost(@PathVariable("id") int id) {
		int i = boardService.deleteBoard(id);
		if(i == 0)
			System.out.println("Failed to add data");
		else
			System.out.println("Successfully added data!");
		return "redirect:../list";
	}
}
