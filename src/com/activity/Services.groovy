package com.activity

import wslite.soap.*

class Services {

	def getRequest(id,fname , lname){
		def client = new SOAPClient('http://192.168.22.10:8080/services/CustomerService')
		def response = client.send(SOAPAction:'http://www.torocommerce.com/customerservice/listCustomer'){
			body {
				ListCustomerRequest(xmlns:'http://www.torocommerce.com/customerservice/'){
					customerIdList(id)
					customerSearch{
						firstName(fname)
						lastName(lname)
						
					}
				}
			}
		}
		
		response.ListCustomerResponse.customerList.firstName
		
	}
}
