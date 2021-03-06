package app.neotech.gestion.de.caisse.controllers;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.neotech.gestion.de.caisse.exceptions.NullException;
import app.neotech.gestion.de.caisse.exceptions.RessourceAlreadyExistException;
import app.neotech.gestion.de.caisse.exceptions.RessourceNotFoundException;
import app.neotech.gestion.de.caisse.mapper.BillMapper;
import app.neotech.gestion.de.caisse.services.BillService;
import app.neotech.gestion.de.caisse.shared.dto.BillDto;

@RestController
@RequestMapping("/bills")
public class BillController {
	
	
	@Autowired
	BillService billService;
	
	@Autowired
	BillMapper billMapper;
	
	@GetMapping(path="/{id}")
	public ResponseEntity<BillDto> getBill(@PathVariable Long id) throws Exception{
		BillDto billDto = billService.getBillById(id);
		return new ResponseEntity<BillDto>(billDto,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto) throws Exception{
		BillDto createBill = billService.createBill(billDto);
		return new ResponseEntity<BillDto>(createBill,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<BillDto> updateBill(@PathVariable Long id,@RequestBody BillDto billDto) throws Exception, RessourceAlreadyExistException{
		BillDto updateBill = billService.updateBill(id, billDto);
		return new ResponseEntity<BillDto>(updateBill,HttpStatus.OK);
		}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteBill(@PathVariable Long id) throws Exception, NullException{
		billService.DeleteBill(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/date/{dateFacture}")
	public ResponseEntity<List<BillDto>> getBillsByDate(@PathVariable("dateFacture") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateFacture)  throws Exception, RessourceNotFoundException{
		List<BillDto> bills = billService.getBillsByDate(dateFacture);
		return new ResponseEntity<List<BillDto>>(bills,HttpStatus.OK);
	}
	
	@GetMapping(path="/{start}/{end}/{total}")
	public ResponseEntity<List<BillDto>> getBillsBetweenAndLess(@PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start,@PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date end,@PathVariable("total") double total) throws Exception,RessourceNotFoundException{		
		List<BillDto> bills = billService.getBillsBetweenDatesAndTotalLess(start, end, total);
		return new ResponseEntity<List<BillDto>>(bills,HttpStatus.OK);
	}
	
	@GetMapping(path="/{start}/{end}")
	public ResponseEntity<List<BillDto>>getBillsBetween(@PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start,@PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date end) throws Exception,RessourceNotFoundException{
		List<BillDto> bills = billService.getBillsBetweenDates(start, end);
		return new ResponseEntity<List<BillDto>>(bills,HttpStatus.OK);
	}
	
	
}
