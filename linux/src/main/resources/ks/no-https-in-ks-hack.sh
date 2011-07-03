#/bin/sh
# This script lives at https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/base-ks.cfg, but ks doesn't like https


cd /tmp
wget https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/f15-white-rabbit-ks.cfg
scp f15-white-rabbit-ks.cfg people.redhat.com:/home/remote/pmcdonou/public_html/src/ks/
