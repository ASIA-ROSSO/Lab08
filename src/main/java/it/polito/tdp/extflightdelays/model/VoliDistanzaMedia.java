package it.polito.tdp.extflightdelays.model;

public class VoliDistanzaMedia {
	
	private Airport originAirport;
	private Airport destinationAirport;
	private int distanzaMedia;
	
	public VoliDistanzaMedia(Airport originAirport, Airport destinationAirport, int distanzaMedia) {
		super();
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.distanzaMedia = distanzaMedia;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public int getDistanzaMedia() {
		return distanzaMedia;
	}
	public void setDistanzaMedia(int distanzaMedia) {
		this.distanzaMedia = distanzaMedia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinationAirport == null) ? 0 : destinationAirport.hashCode());
		result = prime * result + distanzaMedia;
		result = prime * result + ((originAirport == null) ? 0 : originAirport.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoliDistanzaMedia other = (VoliDistanzaMedia) obj;
		if (destinationAirport == null) {
			if (other.destinationAirport != null)
				return false;
		} else if (!destinationAirport.equals(other.destinationAirport))
			return false;
		if (distanzaMedia != other.distanzaMedia)
			return false;
		if (originAirport == null) {
			if (other.originAirport != null)
				return false;
		} else if (!originAirport.equals(other.originAirport))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  originAirport.getAirportName() + "-" + destinationAirport.getAirportName()+ ": " + distanzaMedia;
	}
	
}
