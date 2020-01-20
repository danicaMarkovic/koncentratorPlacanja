package com.example.scientificCenter.dto;

import com.example.scientificCenter.domain.Journal;

public class JournalDTO {
	
	private Long id;
	
	private String title;
	
	private String issn;
	
	private Boolean isActivated;
	
	//private Set<ScientificArea> areas = new HashSet<ScientificArea>();
	
	private Boolean isOpenAccess;
	
	private Double price;
	//private Editor editorInChief;
	
	//private Set<Paper> papers = new HashSet<Paper>();
		
	//private Set<MethodOfPayment> methodOfPayment =new HashSet<MethodOfPayment>();	

	public JournalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public JournalDTO(Long id, String title, String issn, Boolean isActivated, Boolean isOpenAccess, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.issn = issn;
		this.isActivated = isActivated;
		this.isOpenAccess = isOpenAccess;
		this.price = price;
	}



	public JournalDTO(Journal journal) {
		// TODO Auto-generated constructor stub
		this.id = journal.getId();
		this.title = journal.getTitle();
		this.issn = journal.getIssn();
		this.isActivated = journal.getIsActivated();
		this.isOpenAccess = journal.getIsOpenAccess();
		this.price = journal.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Boolean getIsOpenAccess() {
		return isOpenAccess;
	}

	public void setIsOpenAccess(Boolean isOpenAccess) {
		this.isOpenAccess = isOpenAccess;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	

}
