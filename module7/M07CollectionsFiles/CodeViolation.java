import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// data from: https://data.buffalony.gov/Quality-of-Life/Code-Violations/ivrf-k9vm

public class CodeViolation {

	private long id;
	private LocalDate date;
	private Status status;
	private String code, codeSection, description, comments;
	private District district;

	private CodeViolation(Builder builder) {
		this.id = builder.id;
		this.date = builder.date;
		this.status = builder.status;
		this.code = builder.code;
		this.codeSection = builder.codeSection;
		this.description = builder.description;
		this.comments = builder.comments;
		this.district = builder.district;
	}

	public long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Status getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public String getCodeSection() {
		return codeSection;
	}

	public String getDescription() {
		return description;
	}

	public String getComments() {
		return comments;
	}

	public District getDistrict() {
		return district;
	}
	
	@Override
	public String toString() {
		return "ID=" + id + "\tDate=" + date + "\t\tStatus=" + status + "\t\tDistrict=" + district +
				"\n\tCode=" + code + "\tCode Section=" + codeSection + 
				"\n\tDescription: " + description + 
				"\n\tComments: " + comments ;
	}

	public static LocalDate getLocalDate(String localDateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate localDate = LocalDate.parse(localDateString, formatter);
		return localDate;
	}

	public static enum Status {
		ACTIVE, CLOSED, COMPLIED, TRANSFER;

		public static Status getStatus(String statusString) {
			for (Status status : Status.values()) {
				if (status.toString().equalsIgnoreCase(statusString)) {
					return status;
				}
			}
			return null;
		}
		@Override
		public String toString() {
			return super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
		}
	}

	public static enum District {
		DELAWARE, ELLICOTT, FILLMORE, LOVEJOY, MASTEN, NIAGARA, NORTH, SOUTH, UNIVERSITY, UNKNOWN;

		public static District getDistrict(String districtString) {
			for (District district : District.values()) {
				if (district.toString().equalsIgnoreCase(districtString)) {
					return district;
				}
			}
			return null;
		}
		@Override
		public String toString() {
			return super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
		}
	}

	public static class Builder {
		private long id = -1L;
		private LocalDate date;
		private Status status;
		private String code, codeSection, description, comments;
		private District district;

		public Builder() { 	}

		public Builder id(long value) {
			id = value;
			return this;
		}

		public Builder date(LocalDate value) {
			date = value;
			return this;
		}

		public Builder date(String value) {
			date = CodeViolation.getLocalDate(value);
			return this;
		}

		public Builder status(Status value) {
			status = value;
			return this;
		}

		public Builder codeSection(String value) {
			codeSection = value;
			return this;
		}

		public Builder code(String value) {
			code = value;
			return this;
		}

		public Builder description(String value) {
			description = value;
			return this;
		}

		public Builder comments(String value) {
			comments = value;
			return this;
		}

		public Builder district(District value) {
			district = value;
			return this;
		}

		public CodeViolation build() {
			CodeViolation codeViolation = new CodeViolation(this);
			if (id < 0 || date == null || status == null || 
				code == null || codeSection == null || 
				description == null || comments == null || district == null) {
				throw new IllegalStateException("All information about a CodeViolation must be specified.");
			}
			return codeViolation;
		}
	}
}
