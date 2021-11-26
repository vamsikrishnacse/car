package com.rishav.gloginexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Policiesfragment extends Fragment {

    TextView tv2_policy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_policies, container, false);
        tv2_policy = view.findViewById(R.id.tv2_policy);


        tv2_policy.setText("In the current Rental Agreement, the Renter is the person renting the Vehicle specified in the Agreement (hereinafter referred to as the Vehicle) from the Rental Company ABC Rent Estonia Ltd (hereinafter referred to as the Company).\n" +
                "\n" +
                "\n" +
                "\n" +
                "1.    Definitions, Substance of the Agreement and Object of Regulation\n" +
                "1.1.  The following abbreviations and definitions are used hereinafter in the Agreement:\n" +
                "\n" +
                "1.1.1.    The Terms and Conditions – the present standard terms or conditions of rent of the Vehicle which are the basis for rent and use of the Vehicle;\n" +
                "\n" +
                "1.1.2.    The Car Hire Company – the company stated on the front page of the Agreement;\n" +
                "\n" +
                "1.1.3.    The Renter – the person stated on the front page of the Agreement, who received the Vehicle for use from the Car Hire Company according to the present Agreement;\n" +
                "\n" +
                "1.1.4.    The Agreement – the rental agreement concluded between the Car Hire Company and the Renter, which consists of the present Terms and Conditions and the special terms and conditions stated on the front page; T\n" +
                "\n" +
                "1.1.5.    he Vehicle – the Vehicle stated on the front page of the Agreement, the right of use of which belongs to the Car Hire Company, and which the Car Hire Company provides to the Renter for use according to the Agreement.\n" +
                "\n" +
                "1.2.  The present Terms and Conditions establish the rights and obligations of the Renter during use of the Vehicle. The Renter is aware that the right of use of the Vehicle belongs to the Car Hire Company, and that the Renter does not have powers for transfer of the rights and obligations accepted by him or her by conclusion of the Agreement to third persons (among other, for transfer of the right to the Vehicle). Rent or transfer of the Vehicle to third persons is permitted only on the basis of a prior written agreement with the Car Hire Company. The Car Hire Company allows the Renter to use the Vehicle in accordance with the present Terms and Conditions.\n" +
                "\n" +
                "1.3.  The Car Hire Company makes the present Terms and Conditions available to the Renter not later than at the time of conclusion of the Agreement. By signature of the Agreement the Renter confirms and the Renter has read and understood the present Terms and Conditions, and that the Renter undertakes to comply with them.\n" +
                "\n" +
                "1.4.  The Agreement is concluded for use of one Vehicle during the period stated in the Agreement and until return of the Vehicle into direct possession of the Car Hire Company (\"the period of rent”). Provisions of the Terms and Conditions do not become invalid following return of the Vehicle, if their continued validity arises from their substance.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.    Conditions of Use of the Vehicle\n" +
                "\n" +
                "2.1.  According to the Agreement, only the Renter and/or other persons who were included in the Agreement by the Car Hire Company as additional drivers are allowed to drive the vehicle. The Renter and the additional driver stated in the Agreement must possess a driver's license valid in the Republic of Estonia (not the initial driver's license), and he or she must have at least 2 years of driving experience and be at least 22 years of age. Driving of the vehicle is prohibited for the person (including the Renter):\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.1.1.    who does not comply with the requirements established by the Car Hire Company or by the law regarding validity of the driver’s license, age of the person and/or other possible restrictions;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.1.2.    who is under influence of alcoholic, narcotic or other substances, which impede consciousness and delay reaction (\"state of intoxication”), or who is too tired, or whose health condition does not correspond to the requirements arising from the law.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.2.  The Renter is responsible for prudent use and careful driving of the Vehicle, and he or she undertakes to use the Vehicle only according to its designated purposes. The Car Hire Company reserves the right to return the Vehicle into its direct possession at any time, if the Renter does not perform the Terms and Conditions of the Agreement.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.3.  When leaving the Vehicle, the Renter undertakes to lock the Vehicle and to turn on the alarm system, if the Vehicle is equipped with it. The Vehicle must be parked in a place designated for parking. If the Vehicle is equipped with a removable GPS device, the driver must take the device with him or her when leaving the Vehicle and keep it in a secure place. The Renter must not leave valuable items at a visible place in the vehicle. Safety belts and the child-restraint seat must be used according to the legal instruments applicable in the country where the Vehicle is used, and the Renter is responsible for correct installation and use of safety equipment.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.4.  The Renter undertakes to use fuel that is suitable for the Vehicle, and if a warning indicator is lit when the Vehicle is started, to check the level of oil and other liquids, and to contact a representative of the Car Hire Company.If the Vehicle gets into a traffic accident or starts to malfunction, the Car Hire Company has to be immediately informed thereof via telephone. The Vehicle can be taken to a service or repair shop only under a prior permission of the Car Hire Company. It is also forbidden for the Renter to repair the Vehicle on his or her own.\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.  It is forbidden to use the Vehicle:\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.1.    for transport of more people than permitted in the registration certificate or technical specification of the Vehicle;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.2.    for transport of a load that is heavier than permitted in the registration certificate or technical specification of the Vehicle;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.3.    for pushing or towing other vehicles (including trailers) or other objects;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.4.    for driving in off-road conditions or on roads that are not designated for the Vehicle;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.5.    for transport of items that have not been properly attached and fixed;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.6.    for transport of items, transport of which damages the Vehicle of the interior of the Vehicle, or makes it impossible to immediately provide the Vehicle for rent again (including, for example, smell, smoke, strong stains, dirty cabin, scratched parts, etc.);\n" +
                "\n" +
                "2.5.7.    for participation in rallies, test drives and competitions;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.8.    in breach of the Traffic Act and other legal instruments in force;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.9.    for actions contrary to the law;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.10. for sub-renting;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.11. for driving in areas where traffic is prohibited;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.12. for practice driving;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.13. for provision of taxi or shared travel services;\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.5.14. for transport of animals.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.6.  When concluding the Agreement, the Renter undertakes to inform the Car Hire Company of the length of his or her travel route. The Vehicle can be used only in the territory of the Republic of Estonia, if the Agreement does not include a note permitting crossing of the state border. In case of breach of this restriction the Renter is fully liable towards the Car Hire Company for any damage caused to the Vehicle and/or its parts, and/or damage or injury caused to third persons, including for the costs of return of the Vehicle to Estonia. Application of the limitations of liability described in Section 4.2. does not release the Renter from such liability.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.7.  Smoking, consumption of alcoholic drinks and other narcotic substances in the Vehicle is prohibited.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.8.  The Renter is aware that a GPS search system is installed in the Vehicle, allowing the Car Hire Company, if necessary, to identify location and speed of the Vehicle, activate its alarm system, activate blinking hazard lights and shut down the engine during the trip. The Car Hire Company has the right to search for the Vehicle that was not returned by the due time using the GPS search system, and, if necessary, to prevent its further movement and communicate the information regarding location of the Vehicle received through the search system to the police, to the owner of the Vehicle, to the insurer, and, if necessary, to authorized partners of the Car Hire Company used by the Car Hire Company for searching for Vehicles.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.8.1.    During the effective period of the Agreement the Car Hire Company does not use the GPS search system of the Vehicle, and does not monitor movement of the Vehicle, unless it has a legitimate reason to suspect or it has received information that the Renter has materially breached the Agreement (for example: the Vehicle is in a country which it is not allowed to enter according to the Agreement), or if it is required by the police or any other institution/insurer of the Vehicle/owner of the Vehicle.\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "3.    Transfer and Return of the Vechicle\n" +
                "\n" +
                "\n" +
                "3.1.  The Car Hire Company transfer to the Renter the Vehicle in an operating condition together with documents required for driving. The documents required for driving include documents that are required for use of the Vehicle by law, according to the information provided by the Renter to the Car Hire Company during booking of the Vehicle. Usually the documents required for driving are a copy of the registration certificate and the Agreement.\n" +
                "\n" +
                "3.2.  The Renter undertakes to return the Vehicle to the Car Hire Company in the place, on the date and at the clock time stated in the Agreement, and the Vehicle must be equipped in the same way and have the same documents as at the time of transfer of the Vehicle to the Renter.\n" +
                "\n" +
                "3.3.  The Car Hire Company has the right to early cancellation of the Agreement if it discovers that the Renter has materially breached the Terms and Conditions of the Contract, or submitted incorrect information to the Car Hire Company when he or she rented the Vehicle,\n" +
                "or does not manage to properly use the Vehicle. If the Car Hire Company demands early termination of the Agreement on the grounds described in the present Section, the Renter undertakes to immediately return the Vehicle to the Car Hire Company.\n" +
                "\n" +
                "3.4.  The Renter checks condition of the Vehicle when it is transferred by the Car Hire Company, and the Renter confirms with his or her signature on the front page of the Agreement that the Vehicle corresponds to descriptions provided in the Agreement.  If the Renter identifies differences between descriptions provided in the Agreement and the actual condition of the Vehicle, the Renter must let the Car Hire Company make respective notes in the Agreement. During the period of rent the Renter is responsible for prudent use of the Vehicle, for careful driving, for additional equipment and documents required for driving, as well as for regular cleaning of the Vehicle during the period of rent.\n" +
                "\n" +
                "3.5.  The Renter undertakes to return the Vehicle to the office of the Car Hire Company stated in the Agreement during its business hours. During the business hours the Renter has the right to demand from the Car Hire Company to inspect the Vehicle and record new faults. If the Renter waives this right, the Renter is responsible for the Vehicle until the time when the Car Hire Company performs inspection of the Vehicle and takes it into its direct possession. If the Renter returns the Vehicle outside the business hours, the Renter must observe the rules of return of Vehicles outside the business hours effective in the given Car Hire Company. In case of return outside the business hours or in case of return of the keys and the documents to the \"key box”, the Renter is responsible for the Vehicle until the time when direct possession of the Vehicle was accepted by the Car Hire Company. Direct possession of the Vehicle is deemed as having been accepted by the Car Hire Company, if the Car Hire Company received the keys of the Vehicle and had an opportunity to inspect the Vehicle (not later than within 72 hours after the time of return of the Vehicle stated in the Agreement).\n" +
                "\n" +
                "3.6.  If the Renter and the Car Hire Company agreed that the Vehicle will be returned in a place other than the office of the Car Hire Company, the Renter is responsible for the Vehicle and bears all possible costs related to the Vehicle until the time when the Car Hire Company accepted the Vehicle into its direct possession.\n" +
                "\n" +
                "3.7.  If the Renter does not return the Vehicle in the agreed place at the time of return stated in the Agreement, the Renter pays for every starting 24-hour period the rental charge for one day stated in the Agreement (additional days of rent are calculated according to Section 5.3.).\n" +
                "\n" +
                "3.8.  If the Renter returns the Vehicle, but does not return the documents and/or keys of the Vehicle in the agreed place, the Renter pays for every starting 24-hour period the rental charge for one day stated in the Agreement (additional days of rent are calculated according to Section 5.3.), until he or she returns the keys and the documents to the agreed place.\n" +
                "\n" +
                "3.9.  The Renter undertakes to pay an additional charge for cleaning of the Vehicle, if after the Vehicle is returned the Car Hire Company has to use a more thorough cleaning than the standard one. The amount of the additional charge depends on the actual cost of cleaning performed by the service provider selected by the Car Hire Company at own discretion.\n" +
                "\n" +
                "3.10.             If the Renter returns the Vehicle having exceeded the agreed mileage limit stated on the front page of the Agreement, the Renter undertakes to pay to the Car Hire Company the charge stated on the front page of the Agreement per every kilometer exceeding the permitted limit.\n" +
                "\n" +
                "3.11.             If weather conditions, darkness, place and/or time of return of the Vehicle do not allow the Car Hire Company to discover loss of parts of the Vehicle, and/or damage caused to the Vehicle and/or to its parts during the period of rent, or if it is harder to make such discovery due to dirty condition of the Vehicle, location of the damage and/or initial location of the missing parts, the Car Hire Company has the right to demand from the Renter reimbursement of the damage also if such damage is discovered only after acceptance of return the Vehicle. The Car Hire Company has the right to demand, on the basis of the present Section, reimbursement of only such damage which was discovered not later than within 72 hours after acceptance of the Vehicle, under condition that during that time the Vehicle was not already rented to another person.\n" +
                "\n" +
                "4.    Liability of the Renter\n" +
                "\n" +
                "4.1.  During the period of rent the Renter is fully liable for damage, theft and loss of the Vehicle and its parts. Parts of the Vehicle also include additional equipment provided together with the Vehicle. The Renter is not liable for damage only in the extent in which such damage is reimbursed to the Car Hire Company by the insurer (for example, reimbursements provided by motor third party liability insurance), or for which the Renter is not liable according to limitation of liability chosen by him or her and stated on the front page of the Agreement or included in the price of rent. If the Renter breaches the Agreement, no limitation of liability is applied, and in such case the Renter reimburses to the Car Hire Company all damage incurred by it. If a respective limitation of liability was not chosen or is not applicable due to another reason, the Renter reimburses to the Car Hire Company, among other, the cost of repair and/or replacement of the Vehicle or its parts, the revenue from rent lost due to repair or replacement of the Vehicle, the costs of parking and removal of the Vehicle, and the resulting administrative costs. The Car Hire Company has the right to choose at own discretion an insurer or extent of insurance protection, a repair company for the Vehicle, a seller of a replacement Vehicle or parts, or another service provider.\n" +
                "\n" +
                "4.2.   If the Renter has duly performed all Terms and Conditions of the Agreement, and damage, loss or theft of the Vehicle or its parts was not caused by an unauthorized user or due to negligence or intent of an authorized user (including consumption of alcoholic, narcotic, toxic, psychotropic or other intoxicating substances), liability of the Renter is limited as follows, provided that limitation of respective liability is stated on the front page of the Agreement.\n" +
                "\n" +
                "4.2.1.    if the super additional insurance (\"SCDW”) applies, in case of damage, theft or loss of the Vehicle or its parts excess is not applied to the Renter or is reduced to the agreed degree. SCDW is applicable only subject to prior acceptance of CDW and THW. SCDW does not release the Renter from liability in case of damage to the cabin and loss or damage to additional equipment. The super additional insurance does not cover tires.\n" +
                "If the limitations of liability stated in Subsection 4.2. of the Agreement are applicable, the Renter pays excess to the Car Hire Company separately for every event.\n" +
                "\n" +
                "4.3.  The Renter is fully liable for damage caused to the Vehicle due to inability of the driver to consider the height or clearance of the Vehicle. Application of the limitations of liability described in Section 4.2. does not release the Renter from such liability.\n" +
                "\n" +
                "4.4.  The limitations of liability described in Section 4.2. do not apply to malfunctions of engine, transmission and clutch, if they were caused due to use of incorrect driving technique. The cause of damage is established by an expert examination performed by the official dealer of the Vehicle in Estonia.\n" +
                "\n" +
                "4.5.   For every puncture of a tire during the period of rent the Renter undertakes to pay the penalty according to Section 10.\n" +
                "\n" +
                "4.6.  For every case of loss of additional equipment provided together with the Vehicle for the period of rent the Renter undertakes to pay the penalty according to Section 10. Application of the limitations of liability described in Section 4.2. does not release the Renter from such obligation.\n" +
                "\n" +
                "4.7.  The Renter undertakes to pay to the Car Hire Company the penalty amounting to the rental charge for up to 30 days, for the downtime caused by temporary inoperability of the Vehicle resulting from the damage caused to the Vehicle due to an accident or other incident that happened due to the Renter’s fault. Downtime is calculated from the day of the accident or the day when the damage was caused, until the day when the Vehicle was taken back into operation.\n" +
                "\n" +
                "\n" +
                "\n" +
                "5.    Charges and Terms of Payment\n" +
                "\n" +
                "5.1.  The rental charge is the price of the use of the Vehicle under the Terms and Conditions agreed upon at the time of signature of the Agreement. The rental charge includes the rent and charges for additional services (including limitations of liability) that were accepted by the Renter and stated on the front page of the Agreement. All charges are subject to taxation according to the legal instruments of the Republic of Estonia.\n" +
                "\n" +
                "5.2.  The rental charge is calculated on the basis of the price of rent effective at the time of booking of the Vehicle or conclusion of the Agreement, together with the prices of services included in the price of rent, and on the basis of the pricelist for additional services which is available to the Renter on the website and in the office of the Car Hire Company. 3.1 The Renter undertakes to perform the terms of validity of the price of rent. The terms of validity of the price include the terms of the period of rent, minimum duration of rent, available discounts, etc. In case of extension of the Agreement, calculation of the rental charge is based on the price of rent valid at the time of extension, which will be applicable to the entire period of extension. Booking of the Vehicle does not guarantee that the Renter will receive a specific car model (including color). It only guarantees that the Renter will receive a Vehicle belonging to a vehicle group distinguished on the basis of specific conditions. The Renter can choose a Vehicle that is different from the booked vehicle group for an additional charge.\n" +
                "\n" +
                "5.3.   Days of rent are calculated as 24-hour periods starting from the starting time of the period of rent of the Vehicle. Every following day of rent starts on the next day at the clock time when the Vehicle was provided on the first day, and 20% of the price of rent for one day of rent is added for every kilometer exceeding the permitted limit. If the start of the day of rent is exceeded by more than five hours, the Renter undertakes to pay the entire price of the day of rent.\n" +
                "\n" +
                "5.4.  If the Renter returns the Vehicle to the Car Hire Company before the date stated in the Agreement, the price of rent is calculated according to the prices applicable to a shorter (actual) period of rent stated in the pricelist.\n" +
                "\n" +
                "5.5.  Based on the actual use of the Vehicle by the Renter, costs that could not have been foreseen at the start of the period of rent can be added to the rental charge. Such costs include costs related to failure to observe the terms of validity of the price of rent, costs related to failure to observe the time and/or place of return stated in the Agreement, costs related to reimbursement of damage caused to the Vehicle and/or its parts, charge for filling the tank and resulting service charge, costs resulting from return of the Vehicle outside the business hours and/or office of the Car Hire Company, costs of additional cleaning, costs of traffic and parking fines and resulting administration costs, costs arising from breach of the Terms and Conditions of the Agreement, and other costs arising from the use of the Vehicle by the Renter, unless the Car Hire Company and the Renter agreed otherwise. The Renter undertakes to pay all the above costs in full.\n" +
                "\n" +
                "5.6.  Final monetary obligations of the Renter are established after return of the Vehicle.\n" +
                "\n" +
                "5.7.  Deposit is paid by the Renter as earnest money for confirmation of conclusion of the Agreement and as a security of its performance. The Car Hire Company has the right to use the security to offset costs of rent services or other costs arising during the period of rent, or any respective damage.\n" +
                "\n" +
                "5.8.  The Car Hire Company has the right to demand from the Renter payment of the rental charge and\n" +
                "the security on the basis of the effective pricelist.\n" +
                "\n" +
                "5.9.  By completion of the booking the Renter provides to the Car Hire Company the right to debit all obligations arising from the Agreement (rental charge, security) from the credit card, payment card of the Renter, or using another payment method accepted by the Car Hire Company.\n" +
                "\n" +
                "5.10.             The Car Hire Company has the right to deposit (or pre-authorize) the amount equal to the minimum cost of rent, excess, cost of a full tank and filling service charge.\n" +
                "\n" +
                "5.11.             In order to cancel the booking the Renter must submit an application at the office of the Car Hire Company located at the address Paldiski mnt 105 or Lõõtsa 8 A in Tallinn, or send it to the e-mail address info@abcrent.ee.\n" +
                "\n" +
                "5.12.             If the booking is cancelled not later than 48 hours before the start of the booking, the cancellation charge is 10% of the cost of booking, however, not less than the price of rent for one day.\n" +
                "\n" +
                "5.13.             If the booking is cancelled later than 48 hours before the start of the booking, or in case of no-show of the Renter, the cancellation charge is 100% of the cost of booking, i.e. all prepaid amounts (including security) are not subject to refund in any case.\n" +
                "\n" +
                "5.14.             If the booking is cancelled due to circumstances caused by the Renter (for example, among other, due to absence of the driver’s license and/or other documents, absence of a suitable bank card or funds, submission of incorrect data, etc.), the cancellation charge is 100% of the cost of booking, i.e. all prepaid amounts are not subject to refund in any case.\n");
        return view;
    }
}