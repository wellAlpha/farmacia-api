output "database_instance_ip" {
  value = google_sql_database_instance.farmacia.ip_address
}

output "database_instance_port" {
  value = google_sql_database_instance.farmacia.port
}

output "database_name" {
  value = google_sql_database_instance.farmacia.database
}

output "database_user_name" {
  value = google_sql_user.user.name
}

output "database_user_password" {
  value = google_sql_user.user.password
}