#/bin/sh

cd /tmp
wget https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/f15-white-rabbit-ks.cfg
scp f15-white-rabbit-ks.cfg people.redhat.com:/home/remote/pmcdonou/public_html/src/ks/
