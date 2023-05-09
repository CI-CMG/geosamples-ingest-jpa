package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;

public interface ApprovalResource<I> extends EntityWithId<I> {
  GeosamplesApprovalEntity getApproval();
  void setApproval(GeosamplesApprovalEntity approval);
}
