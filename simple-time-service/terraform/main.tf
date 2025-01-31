provider "google" {
  project = var.project_id
  region  = var.region
}

resource "google_container_cluster" "primary" {
  name     = "simple-time-cluster"
  location = var.region

  remove_default_node_pool = true
  initial_node_count       = 1

  node_config {
    machine_type = "e2-medium"
    disk_size_gb = 10
    oauth_scopes = ["https://www.googleapis.com/auth/cloud-platform"]
  }
}
