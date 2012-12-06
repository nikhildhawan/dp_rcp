package org.iiitb.assignment.mt2011090_rcp.mainwizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.iiitb.assignment.mt2011090_rcp.myutil.Logger;
import org.iiitb.assignment.mt2011090_rcp.myutil.Query;
import org.iiitb.assignment.mt2011090_rcp.pages.RouteDetails;
import org.iiitb.assignment.mt2011090_rcp.pages.ScheduleDetails;
import org.iiitb.assignment.mt2011090_rcp.pages.TourDetails;


public class TravelWizard extends Wizard implements INewWizard {

	protected TourDetails tourDetails;
	protected RouteDetails routeDetails;
	protected ScheduleDetails scheduledetails;
	
	public TravelWizard() {
		// TODO Auto-generated constructor stub
		super();
		setNeedsProgressMonitor(true);
	}

	public void addPages(){
		
		tourDetails = new TourDetails();
		routeDetails = new RouteDetails();
		scheduledetails = new ScheduleDetails();
		
		addPage(tourDetails);
		addPage(routeDetails);
		addPage(scheduledetails);
		
		
	}
	
	/*public boolean canFinish(){
		
		if(getContainer().getCurrentPage()== tourDetails )
			return false;
		else
			return true;
	}*/
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		Logger.log("Initializing");
	}

	@Override
	public boolean performFinish() {
		Logger.log(tourDetails.getT_tour());
		Logger.log(routeDetails.getT_from());
		Logger.log(routeDetails.getT_dest());
		Logger.log(routeDetails.getT_via());
		Logger.log(scheduledetails.getC_agent());
		Logger.log(scheduledetails.getDate());
		String sqlQuery;
		try{
			sqlQuery = "insert into tourdetails (tourdetails_name,tourdetails_from,tourdetails_dest,tourdetails_via,tourdetails_agent,tourdetails_date) values ('"+ tourDetails.getT_tour() +"','"+ routeDetails.getT_from() +"','"+ routeDetails.getT_dest() +"','"+ routeDetails.getT_via() +"','"+ scheduledetails.getC_agent() +"','"+ scheduledetails.getDate() +"')";
			Logger.log(sqlQuery);
			Query.Update(sqlQuery);
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
			
		return true;
	}

}
