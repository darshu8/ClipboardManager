package com.clipboard.clipboard;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClipboardController {

	@GetMapping("/copyText/{text}")
	public String setClipboardByGetMethod(@PathVariable String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		return text.toUpperCase();
	}
	
	@PostMapping("/copyText")
	public Message setClipboardByPostMethod(@RequestBody Message msg) {
		StringSelection stringSelection = new StringSelection(msg.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		return msg;
	}
	
	@GetMapping("/getText")
	public Message getClipboardByGetMethod() throws HeadlessException, UnsupportedFlavorException, IOException {
		String message = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor); 
		Message msg = new Message();
		msg.setText(message);
		return msg;
	}
	
}
